package tlvparser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubivelox.gaia.GaiaException;
import com.ubivelox.gaia.util.GaiaUtils;

import exception.UbiveloxException;

public class TlvParser2
{

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

    public enum ValueType
    {
        PRIMITIVE,
        CONSTRUCTED;
    }

    private static final Logger logger = LoggerFactory.getLogger(TlvParserTest.class);





    public Object parse(final String hexaString) throws GaiaException, UbiveloxException
    {
        byte[] byteArray = GaiaUtils.convertHexaStringToByteArray(hexaString);
        return parse1(byteArray, 0, 0, byteArray.length);

    }





    private Object parse1(final byte[] byteArrayOrg, final int indexOrg, final int deptOrg, final int endIndex) throws GaiaException, UbiveloxException
    {

        int index = indexOrg;
        byte[] byteArray = byteArrayOrg;
        String result = "";
        int byteIndex = 0;
        TLVResultNBytePosition parseOne = null;

        do
        {
            int dept = deptOrg;
            String output = "";
            String deptTap = "";

            ValueType valueType = ValueType.PRIMITIVE;
            String hexaTag = "";
            String hexaLength = "";
            String hexaValue = "";
            int valueSize = 0;
            int lengthSize = 0;

            if ( (byteArray[index] & 0b0010_0000) == 0b0010_0000 )
            {
                valueType = ValueType.CONSTRUCTED;

            }
            else
            {
                valueType = ValueType.PRIMITIVE;
            }

            if ( (byteArray[index] & 0b0001_1111) == 0b0001_1111 )
            {
                hexaTag = GaiaUtils.convertByteToHexaString(byteArray[index++]);
                hexaTag += GaiaUtils.convertByteToHexaString(byteArray[index++]);
            }
            else
            {
                hexaTag = GaiaUtils.convertByteToHexaString(byteArray[index++]);
            }

            if ( (byteArray[index] & 0x81) == 0x81 )
            {
                valueSize = Integer.parseInt(GaiaUtils.convertByteToHexaString(byteArray[index + 1]), 16);
            }

            else
            {
                valueSize = Integer.parseInt(GaiaUtils.convertByteToHexaString(byteArray[index]), 16);
            }

            lengthSize = getLengthCount(byteArray, index);

            lengthSize = index + lengthSize;

            for ( int i = index; i < lengthSize; i++ )
            {
                hexaLength += GaiaUtils.convertByteToHexaString(byteArray[index++]);
            }

            for ( int i = 0; i < dept; i++ )
            {
                deptTap += "\t";
            }

            output += deptTap + hexaTag + "\t" + hexaLength;

            if ( valueType == ValueType.PRIMITIVE )

            {

                if ( !(valueSize == 0) )
                {
                    for ( int i = index; i < index + valueSize; i++ )
                    {
                        hexaValue += GaiaUtils.convertByteToHexaString(byteArray[i]);
                    }

                    output += "\t" + hexaValue;
                }
            }
            else
            {
                dept++;

                if ( !(byteArray.length == index) )
                {
                    output += "\n" + parse1(byteArray, index, dept, valueSize);
                }
            }

            // parseOne = new TLVResultNBytePosition(output, index + valueSize);
            parseOne = new TLVResultNBytePosition(output, index);

            // index = parseOne.byteArrayPosition;
            index += valueSize;

            if ( byteIndex == 0 )
            {
                result += "" + parseOne.tlvResult;
            }
            else
            {
                result += "\n" + parseOne.tlvResult;
            }

            byteIndex++;

        }
        while ( endIndex > index );

        return result;

    }





    private int getLengthCount(final byte[] byteArray, final int index) throws GaiaException, UbiveloxException
    {
        GaiaUtils.checkNullOrEmpty(byteArray);

        int lSize = 1;

        if ( (byteArray[index] & 0xff) > 0x81 )
        {
            throw new UbiveloxException("Length Range Overflow");
        }
        else if ( (byteArray[index] & 0xff) == 0x81 )
        {
            logger.info("0x81 들어감");
            lSize += 1;

            if ( index + 1 >= byteArray.length )
            {
                throw new UbiveloxException("Length is not enough");
            }
        }

        return lSize;
    }

}
