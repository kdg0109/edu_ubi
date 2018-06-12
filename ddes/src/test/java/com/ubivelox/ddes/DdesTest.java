package com.ubivelox.ddes;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.junit.Test;

import com.ubivelox.gaia.GaiaException;

public class DdesTest
{

    @Test
    public void test() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, GaiaException,
            InvalidKeySpecException, InvalidAlgorithmParameterException, NoSuchProviderException
    {
        // String 사용했을 때 4142434445464748494A4B4C4D4E4F505152535455565758595A ABCDEFGHIJKLMNOPQRSTUVWXYZ

        // RSA 암 복호화
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", Ddes.rsa("4142434445464748494A4B4C4D4E4F505152535455565758595A"));
        assertEquals("ABCDE", Ddes.rsa("4142434445"));

        // DES/ECB/PKCS5Padding 암 복호화
        assertEquals("892C45B75C686D17A47F93E855A1445B", Ddes.encrypt("3030303046464646", "DES", "DES/ECB/PKCS5Padding"));
        assertEquals("0000FFFF", Ddes.decrypt("892C45B75C686D17A47F93E855A1445B", "DES", "DES/ECB/PKCS5Padding"));

        assertEquals("9DF73E6786F342CD7817629EEBC3E93B354777E78E58C4E235C6EDBBBAB7168F", Ddes.encrypt("4142434445464748494A4B4C4D4E4F505152535455565758595A", "DES", "DES/ECB/PKCS5Padding"));
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", Ddes.decrypt("9DF73E6786F342CD7817629EEBC3E93B354777E78E58C4E235C6EDBBBAB7168F", "DES", "DES/ECB/PKCS5Padding"));

        // AES/CBC/PKCS5Padding 암 복호화
        assertEquals("01F25DAB92993236B0805126A12259D4B5C38A101E3693283609F1B834F87E52", Ddes.encrypt("4142434445464748494A4B4C4D4E4F505152535455565758595A", "AES", "AES/CBC/PKCS5Padding"));
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", Ddes.decrypt("01F25DAB92993236B0805126A12259D4B5C38A101E3693283609F1B834F87E52", "AES", "AES/CBC/PKCS5Padding"));

        // TDES/ECB/PKCS5Padding 암 복호화
        assertEquals("5B36FEBF5A4A10E06CF266655AE73BFF668DA2AA43219FFED3D51954EEBEDB39", Ddes.encrypt("4142434445464748494A4B4C4D4E4F505152535455565758595A", "DESede", "DESede/ECB/PKCS5Padding"));
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", Ddes.decrypt("5B36FEBF5A4A10E06CF266655AE73BFF668DA2AA43219FFED3D51954EEBEDB39", "DESede", "DESede/ECB/PKCS5Padding"));

    }

    String KSP = "404142434445464748494A4B4C4D4E4F";





    @Test
    public void test1() throws UnsupportedEncodingException
    {
        //@formatter:off
        byte[] keyData = new byte[] {
                                     0x40, 0x41, 0x42, 0x43, 0x44, 0x45, 0x46, 0x47
                                   , 0x48, 0x49, 0x4A, 0x4B, 0x4C, 0x4D, 0x4E, 0x4F
                                   , 0x40, 0x41, 0x42, 0x43, 0x44, 0x45, 0x46, 0x47};
        //@formatter:on

        byte[] abc = (this.KSP + this.KSP.substring(0, this.KSP.length() / 2)).getBytes("UTF8");

        for ( byte ab : abc )
        {
            System.out.print(ab);
            System.out.print(" ");

        }

        System.out.println();
        for ( byte ab : keyData )
        {
            System.out.print(ab);
            System.out.print(" ");

        }

    }
}
