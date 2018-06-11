package com.ubivelox.ddes;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import com.ubivelox.gaia.GaiaException;
import com.ubivelox.gaia.util.GaiaUtils;

public class Ddes2
{

//    static //@formatter:off
//    byte[] keyData = new byte[] {
//                                 0x40, 0x41, 0x42, 0x43, 0x44, 0x45, 0x46, 0x47
//                               , 0x48, 0x49, 0x4A, 0x4B, 0x4C, 0x4D, 0x4E, 0x4F
//                               , 0x40, 0x41, 0x42, 0x43, 0x44, 0x45, 0x46, 0x47};
    //@formatter:on

    private static Cipher           CIPHER;
    private static String           KSP = "404142434445464748494A4B4C4D4E4F";
    private static DESedeKeySpec    DESKEYSPEC;
    private static SecretKeyFactory KEYFACTORY;
    private static Key              KEY;

    // private static Cipher CIPHER_2;
    // private static String KSP_2 = "48494A4B4C4D4E4F";
    // private static DESKeySpec DESKEYSPEC_2;
    // private static SecretKeyFactory KEYFACTORY_2;
    // private static Key KEY_2;





    public static String encryt(final String text)
            throws GaiaException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException
    {
        SetEnc();

        byte[] encrytByteArray = null;
        byte[] dencrytByteArray = null;
        String result = "";
        String hexaEnc = "";

        byte[] byteText = text.getBytes();

        encrytByteArray = encryptsByteOne(byteText);
        // encrytByteArray = encryptsByteTwo(encrytByteArray);
        // encrytByteArray = encryptsByteOne(encrytByteArray);

        hexaEnc = GaiaUtils.convertByteArrayToHexaString(encrytByteArray);
        System.out.println(hexaEnc);

        dencrytByteArray = descryptionOne(encrytByteArray);
        // dencrytByteArray = descryptionTwo(dencrytByteArray);
        // dencrytByteArray = descryptionOne(dencrytByteArray);

        // result = new String(dencrytByteArray);

        return hexaEnc;
    }





    // private static byte[] descryptionTwo(final byte[] dencrytByteArray) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException
    // {
    // CIPHER_2.init(Cipher.DECRYPT_MODE, KEY_2);
    //
    // return CIPHER_2.doFinal(dencrytByteArray);
    // }

    private static byte[] descryptionOne(final byte[] encrytByteArray) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException
    {

        CIPHER.init(Cipher.DECRYPT_MODE, KEY);

        return CIPHER.doFinal(encrytByteArray);
    }





    private static byte[] encryptsByteOne(final byte[] encrytByteArray) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException
    {
        CIPHER.init(Cipher.ENCRYPT_MODE, KEY);

        return CIPHER.doFinal(encrytByteArray);
    }

    // private static byte[] encryptsByteTwo(final byte[] encrytByteArray) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException
    // {
    // CIPHER_2.init(Cipher.ENCRYPT_MODE, KEY_2);
    //
    // return CIPHER_2.doFinal(encrytByteArray);
    // }





    // private static byte[] encrypts(final String text) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException
    // {
    // CIPHER.init(Cipher.ENCRYPT_MODE, KEY);
    //
    // return CIPHER.doFinal(text.getBytes());
    // }

    private static void SetEnc() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException, GaiaException
    {
        CIPHER = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        DESKEYSPEC = new DESedeKeySpec(GaiaUtils.convertHexaStringToByteArray(KSP + KSP.substring(0, KSP.length() / 2)));
        // DESKEYSPEC = new DESedeKeySpec(keyData);
        KEYFACTORY = SecretKeyFactory.getInstance("DESede");
        KEY = KEYFACTORY.generateSecret(DESKEYSPEC);

        // CIPHER_2 = Cipher.getInstance("DES/ECB/PKCS5Padding");
        // DESKEYSPEC_2 = new DESKeySpec(KSP_2.getBytes());
        // KEYFACTORY_2 = SecretKeyFactory.getInstance("DES");
        // KEY_2 = KEYFACTORY.generateSecret(DESKEYSPEC_2);
    }

}
