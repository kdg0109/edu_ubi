package tlvparser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubivelox.gaia.GaiaException;
import com.ubivelox.gaia.util.GaiaUtils;

import exception.UbiveloxException;

public class TLVParser
{

    final static int            PRIMITIVE = 0x01;
    final static int            CONSTRUCT = 0x02;

    public static int           valueType = PRIMITIVE;
    private static final Logger logger    = LoggerFactory.getLogger(TlvParserTest.class);





    public static String parse(final String hexString) throws UbiveloxException, GaiaException
    {
        String outPut = "";

        int tSize = 0;
        int lSize = 0;
        int byteArrayPosition = 0;

        // checkNLO(hexString, hexString == null ? 0 : hexString.length(), "HexaString");
        GaiaUtils.checkNullOrEmpty(hexString);
        GaiaUtils.checkHexaString(hexString);

        byte[] byteArray = GaiaUtils.convertHexaStringToByteArray(hexString);

        if ( byteArray[byteArrayPosition] == 0 )
        {
            throw new UbiveloxException("Tag is not correct");
        }

        tSize = getTagSize(byteArray, byteArrayPosition);
        byteArrayPosition = tSize / 2;

        if ( byteArray.length == byteArrayPosition )
        {
            throw new UbiveloxException("Length Range is not exist");

        }
        else
        {
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
        if ( ((byteArray[byteArrPos] & 0xff) & 0x20) == 0x20 )
        {
            valueType = CONSTRUCT;
        }
        else
        {
            valueType = PRIMITIVE;
        }

        if ( ((byteArray[byteArrPos] & 0xff) & 0x1f) == 0x1f )
        {
            tSize += 2;
            for ( int i = byteArrPos + 1; (byteArray[i] & 0xff) >= 0x80; i++ )
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





    // public static byte[] HexToByte(final String hexStr) throws UbiveloxException
    // {
    // checkNLO(hexStr, hexStr == null ? 0 : hexStr.length(), "HexaString");
    //
    // byte[] byteArr = new byte[hexStr.length() / 2];
    //
    // byte evenNum = 0;
    // for ( int i = 0; i < hexStr.length(); i += 2 )
    // {
    //
    // byteArr[i / 2] = (byte) ((byte) ((lookUp.hexMapping(hexStr.charAt(i))) * 16) + lookUp.hexMapping(hexStr.charAt(i + 1)));
    //
    // }
    // return byteArr;
    // }

    private static void checkNLO(final Object obj, final int length, final String type) throws UbiveloxException
    {
        if ( obj == null )
        {
            throw new UbiveloxException(type + " is null");
        }
        if ( length == 0 )
        {
            throw new UbiveloxException(type + " is Empty");
        }
        if ( obj instanceof String && length % 2 != 0 )
        {
            throw new UbiveloxException(type + " length is Odd Number");
        }
    }

}
