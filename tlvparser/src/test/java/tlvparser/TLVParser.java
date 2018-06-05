package tlvparser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubivelox.gaia.GaiaException;
import com.ubivelox.gaia.util.GaiaUtils;

import exception.UbiveloxException;
import lombok.Data;

@Data
public class TLVParser
{

    public enum ValueType
    {
        PRIMITIVE,
        CONSTRUCTED;
    }

    private static final Logger logger = LoggerFactory.getLogger(TlvParserTest.class);

    static class TLVResultNBytePosition
    {
        String tlvResult;
        int    byteArrayPosition;





        public TLVResultNBytePosition(final String tlvResult, final int byteArrayPosition)
        {
            this.tlvResult = tlvResult;
            this.byteArrayPosition = byteArrayPosition;
        }
    }





    public static String parse(final String hexStringOrg) throws UbiveloxException, GaiaException
    {
        byte[] byteArray = GaiaUtils.convertHexaStringToByteArray(hexStringOrg);

        return parse(hexStringOrg, byteArray, 0, 0, -1);
    }





    // 스트링 자르는 위치도 바껴야하고 시작 위치 넘기는 것도 바껴야함
    // 바이트 어레이를 넘기고, 시작 위치 offset을 넘겨야 한다.
    private static String parse(final String hexStringOrg, final byte[] byteArray1, final int bytepos, final int depthOrg, final int subSize) throws UbiveloxException, GaiaException
    {
        GaiaUtils.checkHexaString(hexStringOrg);

        String result = "";
        int hexStringIndex = 0;
        String hexString = hexStringOrg;
        TLVResultNBytePosition parseOne;
        int tlvOneSize = 0;
        int tlvIndex = bytepos;
        int valueSize = -1;
        // 기존꺼는 스트링이 새롭게 계속 들어와서 이를 바이트로 변경함
        byte[] byteArray = byteArray1;

        do
        {
            {
                int depth = depthOrg;
                ValueType valueType = ValueType.PRIMITIVE;
                int byteArrayPosition = tlvIndex;
                String outPut = "";
                String depthTab = "";

                // 이건 딱 그 사이즈 크기
                int tSize = 0;
                int lSize = 0;
                int vSize = 0;

                // primitive와 constructed 구분
                if ( ((byteArray[byteArrayPosition]) & 0b0010_0000) == 0b0010_0000 )
                {
                    valueType = ValueType.CONSTRUCTED;
                }
                else
                {
                    valueType = ValueType.PRIMITIVE;
                }

                tSize = getTagSize(byteArray, byteArrayPosition);
                byteArrayPosition = tSize / 2 + tlvIndex;

                if ( byteArray.length == byteArrayPosition )
                {
                    throw new UbiveloxException("Length Range is not exist");
                }
                else
                {
                    lSize = getLengthSize(byteArray, byteArrayPosition);
                    byteArrayPosition = ((tSize + lSize) / 2) + tlvIndex - 1;

                    for ( int i = 0; i < depth; i++ )
                    {
                        depthTab += "\t";
                    }

                    outPut += depthTab + hexString.substring(tlvIndex * 2, tSize + tlvIndex * 2) + "\t" + hexString.substring(tSize + tlvIndex * 2, tSize + lSize + tlvIndex * 2);

                }

                if ( depth != 0 )
                {
                    // 여기서 subSize는 앞 depth에서 뽑아낸 TLV의 V사이즈임
                    tlvOneSize = subSize;
                    valueSize = (byteArray[byteArrayPosition] & 0xff) * 2;
                }
                else
                {
                    tlvOneSize = hexString.length();
                    valueSize = (byteArray[byteArrayPosition] & 0xff) * 2;
                }

                // length가 0이면 val없이 output
                if ( byteArray[byteArrayPosition] == 0 )
                {
                    parseOne = new TLVResultNBytePosition(outPut, byteArrayPosition);
                    tlvIndex = (tSize + lSize + vSize) / 2 + tlvIndex;

                }
                else
                {

                    if ( (tSize + lSize + tlvIndex * 2) == hexString.length() )
                    {
                        throw new UbiveloxException("Value Range is not exist");
                    }

                    vSize = byteArray[byteArrayPosition] * 2;

                    if ( (tSize + lSize + vSize + tlvIndex * 2) > hexString.length() )
                    {
                        throw new UbiveloxException("Value Range is not enough");
                    }

                    // value의 타입
                    if ( valueType == ValueType.PRIMITIVE )
                    {
                        outPut += "\t" + hexString.substring((tSize + lSize + tlvIndex * 2), (tSize + lSize + vSize + tlvIndex * 2));

                    }
                    else
                    {
                        depth++;

                        outPut += "\n" + parse(hexString, byteArray1, tlvIndex + (tSize + lSize) / 2, depth, valueSize);

                    }

                    parseOne = new TLVResultNBytePosition(outPut, byteArrayPosition + (vSize / 2 + tlvIndex));
                    tlvIndex += (tSize + lSize + vSize) / 2;

                }
            }
            result += (hexStringIndex == 0 ? "" : "\n") + parseOne.tlvResult;
            hexStringIndex = parseOne.byteArrayPosition * 2 + 2;

        }
        while ( tlvIndex != ((tlvOneSize / 2) + bytepos) );

        return result;
    }





    // 옵셋에 맞는 포스가 들가야댐
    static int getTagSize(final byte[] byteArray, int byteArrPos) throws UbiveloxException, GaiaException
    {
        GaiaUtils.checkNullOrEmpty(byteArray);

        int tSize = 2;

        if ( ((byteArray[byteArrPos]) & 0b0001_1111) == 0b0001_1111 )
        {
            tSize += 2;
            for ( int i = byteArrPos + 1; (byteArray[i] & 0b1000_0000) == 0b1000_0000; i++ )
            {
                tSize += 2;
                if ( tSize >= 6 )
                {
                    throw new UbiveloxException("Tag Range Overflow");
                }
            }
        }

        byteArrPos = tSize / 2;
        return tSize;
    }





    // 옵셋에 맞는 포스가 들가야댐
    static int getLengthSize(final byte[] byteArray, final int byteArrPos) throws UbiveloxException, GaiaException
    {
        GaiaUtils.checkNullOrEmpty(byteArray);

        int lSize = 2;

        if ( (byteArray[byteArrPos] & 0xff) > 0x81 )
        {
            throw new UbiveloxException("Length Range Overflow");
        }
        else if ( (byteArray[byteArrPos] & 0xff) == 0x81 )
        {
            logger.info("0x81 들어감");
            lSize += 2;

            if ( byteArrPos + 1 >= byteArray.length )
            {
                throw new UbiveloxException("Length is not enough");
            }
        }

        return lSize;
    }





    public static TLVResultNBytePosition parseOneTLV(final String hexString) throws UbiveloxException, GaiaException
    {

        ValueType valueType = ValueType.PRIMITIVE;
        String outPut = "";

        int tSize = 0;
        int lSize = 0;
        int vSize = 0;
        int byteArrayPosition = 0;

        byte[] byteArray = GaiaUtils.convertHexaStringToByteArray(hexString);

        tSize = getTagSize(byteArray, byteArrayPosition);
        byteArrayPosition = tSize / 2;

        if ( byteArray.length == byteArrayPosition )
        {
            throw new UbiveloxException("Length Range is not exist");

        }
        else
        {
            // primitive와 constructed 구분
            if ( ((byteArray[byteArrayPosition]) & 0b0010_0000) == 0b0010_0000 )
            {
                valueType = ValueType.CONSTRUCTED;
            }
            else
            {
                valueType = ValueType.PRIMITIVE;
            }

            lSize = getLengthSize(byteArray, byteArrayPosition);
            byteArrayPosition = ((tSize + lSize) / 2) - 1;

            outPut += hexString.substring(0, tSize) + "\t" + hexString.substring(tSize, tSize + lSize);
        }
        // length가 0이면 val없이 output
        if ( byteArray[byteArrayPosition] == 0 )
        {
            return new TLVResultNBytePosition(outPut, byteArrayPosition);
        }

        if ( (tSize + lSize) == hexString.length() )
        {
            throw new UbiveloxException("Value Range is not exist");
        }

        vSize = byteArray[byteArrayPosition] * 2;
        // System.out.println("vSize : " + vSize);

        if ( (tSize + lSize + vSize) > hexString.length() )
        {
            throw new UbiveloxException("Value Range is not enough");
        }

        /*
         *
         * value 처리부분
         * 1. return 하기 전에 다음 헥사값이 존재할 때, 현재 TLV의 다음 HexString부터 substring하여 다시 parse를 돈다.
         * 2. parse를 다시 돌릴 때, 다음의 HexString과 byteArrayPosition 값을 파라미터로 넘겨줘야 한다.
         */

        outPut += "\t" + hexString.substring((tSize + lSize), (tSize + lSize + vSize));
        return new TLVResultNBytePosition(outPut, byteArrayPosition + (vSize / 2));
    }
}
