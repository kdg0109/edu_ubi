package com.ubiveloxEdu;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubivelox.changehexa.HexAndByteArray;
import com.ubivelox.changehexa.exception.UbiveloxException;
import com.ubivelox.contents.LookUpTable;

public class Test1
{
    int                         loop   = 500000;

    private static final Logger logger = LoggerFactory.getLogger(Test1.class);





    // 관련 객체 정보 초기화
    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
        StaticValue.setArrayValues();
    }





    @org.junit.Test
    public void testByteToHexUseLookUpTable() throws UbiveloxException
    {
        long start = System.currentTimeMillis();
        long end;
        for ( int i = 0; i < this.loop; i++ )
        {
            assertEquals(StaticValue.HEXA_STRING_ARRAY.get(i % StaticValue.HEXA_STRING_ARRAY.size())
                                                      .toUpperCase(),
                         HexAndByteArray.ByteToHexUseLookUpTable(StaticValue.BYTE_STRING_ARRAY.get(i % StaticValue.BYTE_STRING_ARRAY.size())));
        }
        end = System.currentTimeMillis();
        double resultTime = (end - start) / 1000.0;
        logger.info("lookup table(ByteArray -> HexString) 변환 시간 : " + resultTime);
        // System.out.println("lookup table(ByteArray -> HexString) 변환 시간 : " + resultTime);
    }





    @org.junit.Test
    public void testHexToByteUseLookUpTable() throws UbiveloxException
    {
        long start = System.currentTimeMillis();
        long end;

        for ( int i = 0; i < this.loop; i++ )
        {
            assertArrayEquals(StaticValue.BYTE_STRING_ARRAY.get(i % 17), HexAndByteArray.HexToByteUseLookUpTable(StaticValue.HEXA_STRING_ARRAY.get(i % 17)));
        }

        end = System.currentTimeMillis();
        double resultTime = (end - start) / 1000.0;
        logger.info("lookup table(HexString -> ByteArray) 변환 시간 : " + resultTime);
        // System.out.println("lookup table(HexString -> ByteArray) 변환 시간 : " + resultTime);
    }





    @org.junit.Test
    public void testError() throws UbiveloxException
    {

        // byte[] 에러 확인
        // byte[] == null
        try
        {
            HexAndByteArray.ByteToHexUseLookUpTable(null);
            fail();
        }
        catch ( UbiveloxException e )
        {
            assertEquals("Is null", e.getMessage());
        }

        // byte[].length == 0
        try
        {
            HexAndByteArray.ByteToHexUseLookUpTable(new byte[0]);
            fail();
        }
        catch ( UbiveloxException e )
        {
            assertEquals("Is Empty", e.getMessage());
        }

        // HexaString 에러 확인
        // HexaString == null

        try
        {
            HexAndByteArray.HexToByteUseLookUpTable(null);
            fail();
        }
        catch ( UbiveloxException e )
        {
            assertEquals("Is null", e.getMessage());
        }

        // HexaString.length == 0
        try
        {
            HexAndByteArray.HexToByteUseLookUpTable("");
            fail();
        }
        catch ( UbiveloxException e )
        {
            assertEquals("Is Empty", e.getMessage());
        }

        // HexaString == 홀수
        StringBuffer oddHexStr1 = new StringBuffer("a");
        // 홀수 30개 체크
        for ( int i = 0; i < 30; i++ )
        {
            oddHexStr1.append("aa");
            try
            {
                HexAndByteArray.HexToByteUseLookUpTable(oddHexStr1.toString());
                fail();
            }
            catch ( UbiveloxException e )
            {
                assertEquals("Length is Odd Number", e.getMessage());
            }
        }

        try
        {
            LookUpTable.hexMapping((char) 1);
            fail();
        }
        catch ( UbiveloxException e )
        {
            assertEquals("Incorrect Hexa String Range", e.getMessage());
        }

        try
        {
            LookUpTable.hexMapping((char) 256);
            fail();
        }
        catch ( UbiveloxException e )
        {
            assertEquals("Incorrect Hexa String Range", e.getMessage());
        }

        try
        {
            LookUpTable.hexMapping('가');
            fail();
        }
        catch ( UbiveloxException e )
        {
            assertEquals("Incorrect Hexa String Range", e.getMessage());
        }

        try
        {
            LookUpTable.hexMapping('힣');
            fail();
        }
        catch ( UbiveloxException e )
        {
            assertEquals("Incorrect Hexa String Range", e.getMessage());
        }
    }
}
