package com.ubivelox.ddes;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
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
            InvalidKeySpecException
    {
        // String 사용했을 때 4142434445464748494A4B4C4D4E4F505152535455565758595A ABCDEFGHIJKLMNOPQRSTUVWXYZ
        assertEquals("5B36FEBF5A4A10E06CF266655AE73BFF668DA2AA43219FFED3D51954EEBEDB39", Ddes.encrypt("4142434445464748494A4B4C4D4E4F505152535455565758595A", "DESede"));
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", Ddes.decrypt("5B36FEBF5A4A10E06CF266655AE73BFF668DA2AA43219FFED3D51954EEBEDB39", "DESede"));

        // byte Array 사용했을 때
        // assertEquals("5B36FEBF5A4A10E06CF266655AE73BFF668DA2AA43219FFED3D51954EEBEDB39", Ddes.getEncrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "DESede"));
        // assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", Ddes.getDecryption("5B36FEBF5A4A10E06CF266655AE73BFF668DA2AA43219FFED3D51954EEBEDB39", "DESede"));

        // System.out.println(Ddes.getEncrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "DESede"));

        // Ddes2.encryt("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

        // System.out.println(Ddes.getDecryption(Ddes.getEncrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZX", "DES"), "DES"));
    }

    // 1. byteArray로 0x40 0x41~ 이렇게 받았을 때 결과값이 아래 사이트의 결과와 근사치가 안나오는 이유

    // 1. https://www.tools4noobs.com/online_tools/encrypt/ 에서 key는 바이트가 아닌, 각 문자 하나 자체가 1바이트
    // 자바 api를 이용하여 A~Z까지의 암호화된 String값은 4C2364BED59A211A24889D4B275DE38923BFB61931659C916BA0FFFBF4DA8006
    // 저 사이트에서는 4c2364bed59a211a24889d4b275de38923bfb61931659c91fca9b8b6daa74050
    // ABCDEFGHIJKLMNOPQRSTUVWXYZ
    // 2. 자바에서 사용하는 패딩이 PKCS5 Padding 이라서 ABCDEFGHIJKLMNOPQRSTUVWXYZ 이거 뒤에 6 6 6 6 6 6 이라는 연속된 숫자

    // String을 getBytes로 뽑았을 경우,
    // 52 48 52 49 52 50 52 51 52 52 52 53 52 54 52 55 52 56 52 57 52 65 52 66 52 67 52 68 52 69 52 70 52 48 52 49 52 50 52 51 52 52 52 53 52 54 52 55

    // byte데이터를 출력했을 때
    // 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 64 65 66 67 68 69 70 71
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
