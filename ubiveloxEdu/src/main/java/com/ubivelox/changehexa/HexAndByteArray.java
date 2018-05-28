package com.ubivelox.changehexa;

import com.ubivelox.changehexa.exception.UbiveloxException;
import com.ubivelox.contents.LookUpTable;

public class HexAndByteArray
{

    static LookUpTable lookUp = new LookUpTable();





    public static String ByteToHexUseLookUpTable(final byte[] byteArr) throws UbiveloxException
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

        byte[] byteArr = new byte[hexStr.length() / 2];

        byte evenNum = 0; // 짝수(두 글자 중 앞)
        for ( int i = 0; i < hexStr.length(); i += 2 )
        {

            byteArr[i / 2] = (byte) ((byte) ((lookUp.hexMapping(hexStr.charAt(i))) * 16) + lookUp.hexMapping(hexStr.charAt(i + 1)));

        }
        return byteArr;
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
