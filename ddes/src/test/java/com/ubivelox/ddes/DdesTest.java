package com.ubivelox.ddes;

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
        // assertEquals("4c2364bed59a211a24889d4b275de38923bfb61931659c91fca9b8b6daa74050", Ddes.getEncrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "DESede"));
        // assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", Ddes.getDecryption("4c2364bed59a211a24889d4b275de38923bfb61931659c91fca9b8b6daa74050", "DESede"));

        System.out.println(Ddes.getEncrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "DESede"));
        Ddes2.encryt("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

        // System.out.println(Ddes.getDecryption(Ddes.getEncrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZX", "DES"), "DES"));
    }
}
