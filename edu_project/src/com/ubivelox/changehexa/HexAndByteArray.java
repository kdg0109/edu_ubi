package com.ubivelox.changehexa;

import com.ubivelox.changehexa.exception.UbiveloxException;
import com.ubivelox.contents.LookUpTable;

public class HexAndByteArray
{

    static LookUpTable lookUp = new LookUpTable();





    public static String ByteToHex(final byte[] byteArr) throws UbiveloxException
    {

        checkNLO(byteArr, byteArr == null ? 0 : byteArr.length);

        StringBuffer hexStr = new StringBuffer();

        for ( byte byteVal : byteArr )
        {
            hexStr.append(getHex(byteVal));
        }

        return hexStr.toString();
    }





    public static String ByteToHexUseLookUpTable1(final byte[] byteArr) throws UbiveloxException
    {
        checkNLO(byteArr, byteArr == null ? 0 : byteArr.length);

        StringBuffer hexStr = new StringBuffer(byteArr.length * 2);

        for ( byte byteVal : byteArr )
        {
            hexStr.append(lookUp.mapping(byteVal));
        }

        return hexStr.toString();
    }





    public static byte[] HexToByteUseLookUpTable(final String hexStr) throws UbiveloxException
    {
        checkNLO(hexStr, hexStr == null ? 0 : hexStr.length());

        String hexStrUpper = hexStr.toUpperCase();

        byte[] byteArr = new byte[hexStrUpper.length() / 2];

        for ( int i = 0; i < hexStrUpper.length(); i += 2 )
        {
            byteArr[i / 2] = lookUp.equal(hexStrUpper.substring(i, i + 2)); // 구한 값을 바이트로 변환하여 저장
        }

        return byteArr;
    }





    public static byte[] HexToByteUseLookUpTable2(final String hexStr) throws UbiveloxException
    {
        checkNLO(hexStr, hexStr == null ? 0 : hexStr.length());

        byte[] byteArr = new byte[hexStr.length() / 2];

        byte evenNum = 0; // 짝수(두 글자 중 앞)
        byte oddNum = 0; // 홀수(두 글자 중 뒤)
        for ( int i = 0; i < hexStr.length(); i++ )
        {
            oddNum = (lookUp.hexMapping(hexStr.charAt(i)));

            if ( i % 2 == 0 )
            {
                evenNum = (byte) (oddNum * 16);
            }
            else
            {
                byteArr[i / 2] = (byte) (evenNum + oddNum);
            }
        }

        return byteArr;
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





    // Null인지 Length가 0인지 홀수 길이 인지
    private static void checkNLO(final Object obj, final int length) throws UbiveloxException
    {
        if ( obj == null )
        {
            throw new UbiveloxException("Is null");
        }
        if ( length == 0 )
        {
            throw new UbiveloxException("Is Empty");
        }
        if ( obj instanceof String && length % 2 != 0 )
        {
            throw new UbiveloxException("Length is Odd Number");
        }
    }
}
