package com.ubivelox.ddes;

import java.io.UnsupportedEncodingException;
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

public class Ddes
{
    // 초기화 및 키 생성
    public static Cipher setInit(final String encryptType, final int opmode) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException, GaiaException
    {
      //@formatter:off
        byte[] keyData = new byte[] {
                                     0x40, 0x41, 0x42, 0x43, 0x44, 0x45, 0x46, 0x47
                                   , 0x48, 0x49, 0x4A, 0x4B, 0x4C, 0x4D, 0x4E, 0x4F
                                   , 0x40, 0x41, 0x42, 0x43, 0x44, 0x45, 0x46, 0x47};
        //@formatter:on

        SecretKeyFactory keyFactory = null;

        keyFactory = SecretKeyFactory.getInstance(encryptType);

        DESedeKeySpec desKeySpec = new DESedeKeySpec(keyData);

        Key key = keyFactory.generateSecret(desKeySpec);

        Cipher cipher = null;

        cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(opmode, key);

        return cipher;
    }





    // 암호화 하기
    public static String getEncrypt(final String plainText, final String encryptType) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException,
            BadPaddingException, UnsupportedEncodingException, GaiaException, InvalidKeySpecException
    {
        GaiaUtils.checkNullOrEmpty(plainText, encryptType);

        Cipher cipher = setInit(encryptType, Cipher.ENCRYPT_MODE);

        byte[] inputBytes = plainText.getBytes("UTF8");

        byte[] outputBytes = cipher.doFinal(inputBytes);

        return GaiaUtils.convertByteArrayToHexaString(outputBytes);
    }





    // 복호화 하기
    public static String getDecryption(final String cipherText, final String encryptType) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException,
            BadPaddingException, UnsupportedEncodingException, GaiaException, InvalidKeySpecException
    {
        GaiaUtils.checkNullOrEmpty(cipherText, encryptType);

        Cipher cipher = setInit(encryptType, Cipher.DECRYPT_MODE);

        byte[] inputBytes = GaiaUtils.convertHexaStringToByteArray(cipherText);

        byte[] outputBytes = cipher.doFinal(inputBytes);

        return new String(outputBytes, "UTF8");
    }

}
