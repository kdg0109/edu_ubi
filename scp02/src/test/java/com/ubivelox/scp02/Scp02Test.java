package com.ubivelox.scp02;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.junit.Test;

import com.ubivelox.gaia.GaiaException;

import exception.UbiveloxException;

public class Scp02Test
{

    @Test
    public void test() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException,
            InvalidKeySpecException, InvalidAlgorithmParameterException, GaiaException, UbiveloxException
    {
        assertEquals("848200001070CA81178C079A4A114998A816CBF511", Scp02.externalAuthenticate("00009151026881950639FF02000D4EB131EA95DE5D29FCFE72F724DC"));

        assertEquals("00009151026881950639FF02000D4EB131EA95DE5D29FCFE72F724DC", Scp02.initializeUpdateResponse("8050000008EC78EEA2438008A6"));

        assertEquals("8050000008EC78EEA2438008A6", Scp02.initializeUpdate("EC78EEA2438008A6"));
    }

}
