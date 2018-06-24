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
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", Ddes.rsa("4142434445464748494A4B4C4D4E4F505152535455565758595A", "RSA"));
        assertEquals("ABCDE", Ddes.rsa("4142434445", "RSA"));

        // DES/ECB/PKCS5Padding 암 복호화
        assertEquals("9DF73E6786F342CD7817629EEBC3E93B354777E78E58C4E235C6EDBBBAB7168F", Ddes.encrypt("4142434445464748494A4B4C4D4E4F505152535455565758595A", "DES", "DES/ECB/PKCS5Padding"));
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", Ddes.decrypt("9DF73E6786F342CD7817629EEBC3E93B354777E78E58C4E235C6EDBBBAB7168F", "DES", "DES/ECB/PKCS5Padding"));
<<<<<<< HEAD

        assertEquals("892C45B75C686D17A47F93E855A1445B", Ddes.encrypt("3030303046464646", "DES", "DES/ECB/PKCS5Padding"));
        assertEquals("0000FFFF", Ddes.decrypt("892C45B75C686D17A47F93E855A1445B", "DES", "DES/ECB/PKCS5Padding"));

=======
        
        assertEquals("892C45B75C686D17A47F93E855A1445B", Ddes.encrypt("3030303046464646", "DES", "DES/ECB/PKCS5Padding"));
        assertEquals("0000FFFF", Ddes.decrypt("892C45B75C686D17A47F93E855A1445B", "DES", "DES/ECB/PKCS5Padding"));
      
>>>>>>> 38a18070ae06a495b8453095b855d0dc342ac0d0
        // DES/ECB/PKCS5Padding 암 복호화
        assertEquals("9DF73E6786F342CD7817629EEBC3E93B354777E78E58C4E235C6EDBBBAB7168F", Ddes.encrypt("4142434445464748494A4B4C4D4E4F505152535455565758595A", "DES", "DES/ECB/PKCS5Padding"));
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", Ddes.decrypt("9DF73E6786F342CD7817629EEBC3E93B354777E78E58C4E235C6EDBBBAB7168F", "DES", "DES/ECB/PKCS5Padding"));
        
        assertEquals("892C45B75C686D17A47F93E855A1445B", Ddes.encrypt("3030303046464646", "DES", "DES/ECB/PKCS5Padding"));
        assertEquals("0000FFFF", Ddes.decrypt("892C45B75C686D17A47F93E855A1445B", "DES", "DES/ECB/PKCS5Padding"));

        // DES/CBC/PKCS5Padding 암 복호화
        assertEquals("9DF73E6786F342CDDD2CEB0480876912501FA9DB099B5EBED2CF09E3D27F1BB8", Ddes.encrypt("4142434445464748494A4B4C4D4E4F505152535455565758595A", "DES", "DES/CBC/PKCS5Padding"));
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", Ddes.decrypt("9DF73E6786F342CDDD2CEB0480876912501FA9DB099B5EBED2CF09E3D27F1BB8", "DES", "DES/CBC/PKCS5Padding"));
        
        assertEquals("892C45B75C686D17DD837CBA520EE3D9", Ddes.encrypt("3030303046464646", "DES", "DES/CBC/PKCS5Padding"));
        assertEquals("0000FFFF", Ddes.decrypt("892C45B75C686D17DD837CBA520EE3D9", "DES", "DES/CBC/PKCS5Padding"));

<<<<<<< HEAD
        assertEquals("892C45B75C686D17A47F93E855A1445B", Ddes.encrypt("3030303046464646", "DES", "DES/ECB/PKCS5Padding"));
        assertEquals("0000FFFF", Ddes.decrypt("892C45B75C686D17A47F93E855A1445B", "DES", "DES/ECB/PKCS5Padding"));

        // DES/CBC/PKCS5Padding 암 복호화
        assertEquals("9DF73E6786F342CDDD2CEB0480876912501FA9DB099B5EBED2CF09E3D27F1BB8", Ddes.encrypt("4142434445464748494A4B4C4D4E4F505152535455565758595A", "DES", "DES/CBC/PKCS5Padding"));
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", Ddes.decrypt("9DF73E6786F342CDDD2CEB0480876912501FA9DB099B5EBED2CF09E3D27F1BB8", "DES", "DES/CBC/PKCS5Padding"));

        assertEquals("892C45B75C686D17DD837CBA520EE3D9", Ddes.encrypt("3030303046464646", "DES", "DES/CBC/PKCS5Padding"));
        assertEquals("0000FFFF", Ddes.decrypt("892C45B75C686D17DD837CBA520EE3D9", "DES", "DES/CBC/PKCS5Padding"));

=======
        
>>>>>>> 38a18070ae06a495b8453095b855d0dc342ac0d0
        // AES/CBC/PKCS5Padding 암 복호화
        assertEquals("FFB131FECFD6C8749B23404112CDAEDB2566FE5DACE4C840927D678BAE6558BE", Ddes.encrypt("4142434445464748494A4B4C4D4E4F505152535455565758595A", "AES", "AES/CBC/PKCS5Padding"));
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", Ddes.decrypt("FFB131FECFD6C8749B23404112CDAEDB2566FE5DACE4C840927D678BAE6558BE", "AES", "AES/CBC/PKCS5Padding"));

        assertEquals("83E3469B244020A31FE762C5D92F076E", Ddes.encrypt("3030303046464646", "AES", "AES/CBC/PKCS5Padding"));
        assertEquals("0000FFFF", Ddes.decrypt("83E3469B244020A31FE762C5D92F076E", "AES", "AES/CBC/PKCS5Padding"));

        // AES/ECB/PKCS5Padding 암 복호화
        assertEquals("FFB131FECFD6C8749B23404112CDAEDB0F59D31708C5719770088C1CF115DF8F", Ddes.encrypt("4142434445464748494A4B4C4D4E4F505152535455565758595A", "AES", "AES/ECB/PKCS5Padding"));
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", Ddes.decrypt("FFB131FECFD6C8749B23404112CDAEDB0F59D31708C5719770088C1CF115DF8F", "AES", "AES/ECB/PKCS5Padding"));

        assertEquals("83E3469B244020A31FE762C5D92F076E", Ddes.encrypt("3030303046464646", "AES", "AES/ECB/PKCS5Padding"));
        assertEquals("0000FFFF", Ddes.decrypt("83E3469B244020A31FE762C5D92F076E", "AES", "AES/ECB/PKCS5Padding"));

        
        // TDES/ECB/PKCS5Padding 암 복호화
        assertEquals("5B36FEBF5A4A10E06CF266655AE73BFF668DA2AA43219FFED3D51954EEBEDB39", Ddes.encrypt("4142434445464748494A4B4C4D4E4F505152535455565758595A", "DESede", "DESede/ECB/PKCS5Padding"));
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", Ddes.decrypt("5B36FEBF5A4A10E06CF266655AE73BFF668DA2AA43219FFED3D51954EEBEDB39", "DESede", "DESede/ECB/PKCS5Padding"));
      
        assertEquals("C70BCBEF32AFFB7220A8A19F543BCCBD", Ddes.encrypt("3030303046464646", "DESede", "DESede/ECB/PKCS5Padding"));
        assertEquals("0000FFFF", Ddes.decrypt("C70BCBEF32AFFB7220A8A19F543BCCBD", "DESede", "DESede/ECB/PKCS5Padding"));

        assertEquals("C70BCBEF32AFFB7220A8A19F543BCCBD", Ddes.encrypt("3030303046464646", "DESede", "DESede/ECB/PKCS5Padding"));
        assertEquals("0000FFFF", Ddes.decrypt("C70BCBEF32AFFB7220A8A19F543BCCBD", "DESede", "DESede/ECB/PKCS5Padding"));

        // TDES/CBC/PKCS5Padding 암 복호화
        assertEquals("5B36FEBF5A4A10E0997A34C4D1AC99323F11D9788CA044349DEDB222A6C02BDF", Ddes.encrypt("4142434445464748494A4B4C4D4E4F505152535455565758595A", "DESede", "DESede/CBC/PKCS5Padding"));
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", Ddes.decrypt("5B36FEBF5A4A10E0997A34C4D1AC99323F11D9788CA044349DEDB222A6C02BDF", "DESede", "DESede/CBC/PKCS5Padding"));

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
