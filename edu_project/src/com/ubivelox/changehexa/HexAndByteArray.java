package com.ubivelox.changehexa;

import com.ubivelox.changehexa.exception.UbiveloxException;
import com.ubivelox.contents.LookUpTable;

public class HexAndByteArray
{

    static LookUpTable lookUp = new LookUpTable();





    public static String ByteToHex(final byte[] byteArr) throws UbiveloxException
    {

        StringBuffer hexStr = new StringBuffer();

        for ( byte byteVal : byteArr )
        {
            hexStr.append(getHex(byteVal));
        }

        return hexStr.toString();
    }





    public static String ByteToHexUseLookUpTable1(final byte[] byteArr) throws UbiveloxException
    {
        StringBuffer hexStr = new StringBuffer();

        for ( byte byteVal : byteArr )
        {
            hexStr.append(lookUp.mapping(byteVal));
        }

        return hexStr.toString();
    }





    public static String ByteToHexUseLookUpTable2(final byte[] byteArr) throws UbiveloxException
    {
        StringBuffer hexStr = new StringBuffer();

        for ( byte byteVal : byteArr )
        {
            hexStr.append(lookUp.hashmapping(byteVal));
        }

        return hexStr.toString();
    }





    private static String getHex(final int byteVal)
    {
        int byteValTmp = 0;
        StringBuffer hexStr = new StringBuffer();

        String hexaStrFirst = "";
        String hexaStrSecond = "";
        String hexaTmp = "";

        byteValTmp = byteVal;

        do
        {
            hexaTmp = "";
            if ( byteValTmp % 16 > 9 )
            {
                switch ( byteValTmp % 16 )
                {
                    case 10:
                        hexaTmp = "A";
                        break;
                    case 11:
                        hexaTmp = "B";
                        break;
                    case 12:
                        hexaTmp = "C";
                        break;
                    case 13:
                        hexaTmp = "D";
                        break;
                    case 14:
                        hexaTmp = "E";
                        break;
                    case 15:
                        hexaTmp = "F";
                }
            }
            else
            {
                hexaTmp += byteValTmp % 16;
            }
            if ( hexaStrSecond.length() <= 0 )
            {
                hexaStrSecond = hexaTmp;
            }
            else
            {
                hexaStrFirst = hexaTmp;
            }

            byteValTmp /= 16;
        }
        while ( byteValTmp > 0 );

        return hexStr.append(hexaStrFirst)
                     .append(hexaStrSecond)
                     .toString();
    }
}
