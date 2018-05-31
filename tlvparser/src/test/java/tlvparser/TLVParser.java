package tlvparser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubivelox.gaia.GaiaException;
import com.ubivelox.gaia.util.GaiaUtils;

import exception.UbiveloxException;

public class TLVParser
{

    final static int            PRIMITIVE   = 0x01;
    final static int            CONSTRUCTED = 0x02;

    private final int           valueType   = PRIMITIVE;
    private static final Logger logger      = LoggerFactory.getLogger(TlvParserTest.class);





    public static String parse(final String hexString) throws UbiveloxException, GaiaException
    {

        int valueType = PRIMITIVE;
        String outPut = "";

        int tSize = 0;
        int lSize = 0;
        int vSize = 0;
        int byteArrayPosition = 0;

        // checkNLO(hexString, hexString == null ? 0 : hexString.length(), "HexaString");
        GaiaUtils.checkHexaString(hexString);

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
                valueType = CONSTRUCTED;
            }
            else
            {
                valueType = PRIMITIVE;
            }

            lSize = getLengthSize(byteArray, byteArrayPosition);
            byteArrayPosition = ((tSize + lSize) / 2) - 1;

            outPut += hexString.substring(0, tSize) + "\t" + hexString.substring(tSize, tSize + lSize);
        }
        // length가 0이면 val없이 output
        if ( byteArray[byteArrayPosition] == 0 )
        {
            return outPut;
        }

        if ( (tSize + lSize) == hexString.length() )
        {
            throw new UbiveloxException("Value Range is not exist");
        }

        vSize = byteArray[byteArrayPosition];
        // System.out.println("val 사이즈 : " + vSize);
        /*
         *
         * value 처리부분
         *
         */

        return outPut + "\t" + hexString.substring((tSize + lSize), hexString.length());
    }





    static int getTagSize(final byte[] byteArray, int byteArrPos) throws UbiveloxException, GaiaException
    {
        // checkNLO(byteArray, byteArray == null ? 0 : byteArray.length, "Tag Byte Array");
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
        // checkNLO(byteArr, byteArr == null ? 0 : byteArr.length, "Length Byte Array");
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
