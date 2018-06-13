package com.ubivelox.ddes;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.ubivelox.gaia.GaiaException;
import com.ubivelox.gaia.util.GaiaUtils;

public class Ddes {
	// 초기화 및 키 생성
	public static Cipher setInit(final String encryptType, final int opmode, final String transformation)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException,
			GaiaException, InvalidAlgorithmParameterException {
		// @formatter:off
		byte[] keyData24 = new byte[] { 0x40, 0x41, 0x42, 0x43, 0x44, 0x45, 0x46, 0x47, 0x48, 0x49, 0x4A, 0x4B, 0x4C,
				0x4D, 0x4E, 0x4F, 0x40, 0x41, 0x42, 0x43, 0x44, 0x45, 0x46, 0x47 };

		//AES
		byte[] keyData16 = new byte[] { 0x40, 0x41, 0x42, 0x43, 0x44, 0x45, 0x46, 0x47, 0x48, 0x49, 0x4A, 0x4B, 0x4C,
				0x4D, 0x4E, 0x4F };

		//DES
		byte[] keyData8 = new byte[] { 0x40, 0x41, 0x42, 0x43, 0x44, 0x45, 0x46, 0x47 };

		// @formatter:on

		Cipher cipher = null;

		if (transformation.contains("DESede")) {
			SecretKeyFactory keyFactory = null;

			keyFactory = SecretKeyFactory.getInstance(encryptType);

			DESedeKeySpec desKeySpec = new DESedeKeySpec(keyData24);

			Key key = keyFactory.generateSecret(desKeySpec);

			cipher = Cipher.getInstance(transformation);
			cipher.init(opmode, key);

			// DES 8비트 키
		} else if (transformation.contains("DES/CBC")) {
			SecretKeySpec keySpec = null;

			keySpec = new SecretKeySpec(keyData8, encryptType);

			// iv를 0으로 초기화
			byte[] iv = new byte[8];

			IvParameterSpec parameterSpec = new IvParameterSpec(iv);

			Key key = keySpec;

			cipher = Cipher.getInstance(transformation);
			cipher.init(opmode, key, parameterSpec);

		} else if (transformation.contains("DES/ECB")) {
			SecretKeyFactory keyFactory = null;

			keyFactory = SecretKeyFactory.getInstance(encryptType);

			DESKeySpec desKeySpec = new DESKeySpec(keyData8);

			Key key = keyFactory.generateSecret(desKeySpec);

			cipher = Cipher.getInstance(transformation);
			cipher.init(opmode, key);

			//AES 16비트 키
		} else if (transformation.contains("AES")) {
			SecretKeySpec keySpec = null;

			keySpec = new SecretKeySpec(keyData16, encryptType);

			Key key = keySpec;
			cipher = Cipher.getInstance(transformation);
			
			if(transformation.contains("ECB")){
				cipher.init(opmode, key);
				
			}else if(transformation.contains("CBC")){
				byte[] iv = new byte[16];
				IvParameterSpec parameterSpec = new IvParameterSpec(iv);
				cipher.init(opmode, key, parameterSpec);
			}
		}

		return cipher;
	}

	// 암호화 하기
	/*
	 * encryptType : 암호화 종류 transformation : 암호화 방법
	 */
	public static String encrypt(final String HexPlainText, final String encryptType, final String transformation)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException, UnsupportedEncodingException, GaiaException, InvalidKeySpecException,
			InvalidAlgorithmParameterException {
		GaiaUtils.checkHexaString(HexPlainText);
		GaiaUtils.checkNullOrEmpty(encryptType, transformation);

		Cipher cipher = setInit(encryptType, Cipher.ENCRYPT_MODE, transformation);

		byte[] inputBytes = GaiaUtils.convertHexaStringToByteArray(HexPlainText);

		byte[] outputBytes = cipher.doFinal(inputBytes);

		return GaiaUtils.convertByteArrayToHexaString(outputBytes);
	}

	// 복호화 하기
	public static String decrypt(final String cipherText, final String encryptType, final String transformation)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException, UnsupportedEncodingException, GaiaException, InvalidKeySpecException,
			InvalidAlgorithmParameterException {
		GaiaUtils.checkNullOrEmpty(cipherText, encryptType, transformation);

		Cipher cipher = setInit(encryptType, Cipher.DECRYPT_MODE, transformation);

		byte[] inputBytes = GaiaUtils.convertHexaStringToByteArray(cipherText);

		byte[] outputBytes = cipher.doFinal(inputBytes);

		return new String(outputBytes, "UTF8");
	}

	public static String rsa(final String HexPlainText, final String encryptType)
			throws NoSuchAlgorithmException, NoSuchProviderException, GaiaException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		String strResult = "";

		GaiaUtils.checkHexaString(HexPlainText);

		// RSA 공개키/개인키를 생성한다.

		KeyPairGenerator clsKeyPairGenerator = KeyPairGenerator.getInstance(encryptType);

		clsKeyPairGenerator.initialize(2048);

		KeyPair clsKeyPair = clsKeyPairGenerator.genKeyPair();

		Key clsPublicKey = clsKeyPair.getPublic();

		Key clsPrivateKey = clsKeyPair.getPrivate();

		// KeyFactory fact = KeyFactory.getInstance(encryptType);
		// RSAPublicKeySpec publicKeySpec = fact.getKeySpec(clsPublicKey,
		// RSAPublicKeySpec.class);
		// RSAPrivateKeySpec privateKeySpec = fact.getKeySpec(clsPrivateKey,
		// RSAPrivateKeySpec.class);
		// System.out.println("public key modulus(" +
		// clsPublicKeySpec.getModulus() + ") exponent(" +
		// clsPublicKeySpec.getPublicExponent() + ")");
		// System.out.println("private key modulus(" +
		// clsPrivateKeySpec.getModulus() + ") exponent(" +
		// clsPrivateKeySpec.getPrivateExponent() + ")");

		// 암호화 한다.
		Cipher cipher = Cipher.getInstance(encryptType);

		cipher.init(Cipher.ENCRYPT_MODE, clsPublicKey);

		byte[] inputBytes = GaiaUtils.convertHexaStringToByteArray(HexPlainText);

		byte[] arrCipherData = cipher.doFinal(inputBytes);

		// String strCipher = new String(arrCipherData);
		// System.out.println(strCipher);
		// System.out.println();

		// 복호화 한다.
		cipher.init(Cipher.DECRYPT_MODE, clsPrivateKey);

		byte[] arrData = cipher.doFinal(arrCipherData);

		strResult = new String(arrData);

		return strResult;
	}
}
