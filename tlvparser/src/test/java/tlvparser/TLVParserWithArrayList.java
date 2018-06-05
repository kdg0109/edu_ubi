package tlvparser;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubivelox.gaia.GaiaException;
import com.ubivelox.gaia.util.GaiaUtils;

import exception.UbiveloxException;
import lombok.Data;
import tlvparser.TLVParserWithArrayListTest.TLVObject;

@Data
public class TLVParserWithArrayList
{

    public enum ValueType
    {
        PRIMITIVE,
        CONSTRUCTED;
    }

    private static final Logger logger = LoggerFactory.getLogger(TlvParserTest.class);

    static class TLVResultNBytePosition
    {
        TLVObject tlvResult;
        int       byteArrayPosition;





        public TLVResultNBytePosition(final TLVObject tlvResult, final int byteArrayPosition)
        {
            this.tlvResult = tlvResult;
            this.byteArrayPosition = byteArrayPosition;
        }
    }





    public static ArrayList<TLVObject> parse(final String hexStringOrg) throws UbiveloxException, GaiaException
    {

        return parse0(hexStringOrg);
    }





    public static ArrayList<TLVObject> parse0(final String hexStringOrg) throws UbiveloxException, GaiaException
    {
        GaiaUtils.checkHexaString(hexStringOrg);

        ArrayList<TLVObject> result = new ArrayList<>();
        int hexStringIndex = 0;
        String hexString = hexStringOrg;
        TLVResultNBytePosition parseOne;
        int tlvIndex = 0;
        byte[] byteArray = GaiaUtils.convertHexaStringToByteArray(hexString);

        do
        {
            {
                ValueType valueType = ValueType.PRIMITIVE;
                int byteArrayPosition = tlvIndex;
                TLVObject tlvObject;
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
                byteArrayPosition += tSize / 2;

                if ( byteArray.length == byteArrayPosition )
                {
                    throw new UbiveloxException("Length Range is not exist");
                }
                else
                {
                    lSize = getLengthSize(byteArray, byteArrayPosition);
                    byteArrayPosition = ((tSize + lSize) / 2) - 1 + tlvIndex;

                }
                // length가 0이면 val없이 output
                if ( byteArray[byteArrayPosition] == 0 )
                {
                    tlvObject = new TLVObject(hexString.substring(0, tSize), hexString.substring(tSize, tSize + lSize), "");
                    parseOne = new TLVResultNBytePosition(tlvObject, byteArrayPosition);
                    tlvIndex += (tSize + lSize + vSize) / 2;
                }
                else
                {

                    if ( (tSize + lSize) == hexString.length() )
                    {
                        throw new UbiveloxException("Value Range is not exist");
                    }

                    vSize = byteArray[byteArrayPosition] * 2;

                    if ( (tSize + lSize + vSize) > hexString.length() )
                    {
                        throw new UbiveloxException("Value Range is not enough");
                    }

                    // value의 타입
                    if ( valueType == ValueType.PRIMITIVE )
                    {
                        tlvObject = new TLVObject(hexString.substring(0, tSize), hexString.substring(tSize, tSize + lSize), hexString.substring((tSize + lSize), (tSize + lSize + vSize)));

                    }
                    else
                    {

                        tlvObject = new TLVObject(hexString.substring(0, tSize), hexString.substring(tSize, tSize + lSize), parse0(hexString.substring((tSize + lSize), (tSize + lSize + vSize))));
                    }

                    parseOne = new TLVResultNBytePosition(tlvObject, byteArrayPosition + (vSize / 2));
                    tlvIndex += (tSize + lSize + vSize) / 2;
                }
            }

            result.add(parseOne.tlvResult);
            hexStringIndex = parseOne.byteArrayPosition * 2 + 2;

            hexString = hexStringOrg.substring(hexStringIndex);

        }
        while ( !hexString.isEmpty() );

        return result;
    }





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
}
