package com.ubivelox.changehexa.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;

import com.ubivelox.changehexa.HexAndByteArray;
import com.ubivelox.changehexa.exception.UbiveloxException;

public class Test
{

    // StaticValue ��� ��� �κ�
    static String hexaString = "";
    static byte[] byteString = null;

    int           loop       = 500000;





    // ���� ��ü ���� �ʱ�ȭ
    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
        StaticValue.setArrayValues();

        hexaString = StaticValue.HEXA_STRING_ARRAY.get(0);
        byteString = StaticValue.BYTE_STRING_ARRAY.get(0);
    }





    @org.junit.Test
    public void testByteToHex() throws UbiveloxException
    {
        long start = System.currentTimeMillis();
        long end;
        for ( int i = 0; i < this.loop; i++ )
        {
            assertEquals(StaticValue.HEXA_STRING_ARRAY.get(i % 17), HexAndByteArray.ByteToHex(StaticValue.BYTE_STRING_ARRAY.get(i % 17)));
        }
        end = System.currentTimeMillis();
        double resultTime = (end - start) / 1000.0;
        System.out.println("lookup table �̻�� ��ȯ �ð� : " + resultTime);
    }





    @org.junit.Test
    public void testByteToHexUseLookUpTable1() throws UbiveloxException
    {
        long start = System.currentTimeMillis();
        long end;
        for ( int i = 0; i < this.loop; i++ )
        {
            assertEquals(StaticValue.HEXA_STRING_ARRAY.get(i % 17), HexAndByteArray.ByteToHexUseLookUpTable1(StaticValue.BYTE_STRING_ARRAY.get(i % 17)));
        }
        end = System.currentTimeMillis();
        double resultTime = (end - start) / 1000.0;
        System.out.println("lookup table(String[]) ��� ��ȯ �ð� : " + resultTime);
    }





    @org.junit.Test
    public void testByteToHexUseLookUpTable2() throws UbiveloxException
    {
        long start = System.currentTimeMillis();
        long end;
        for ( int i = 0; i < this.loop; i++ )
        {
            assertEquals(StaticValue.HEXA_STRING_ARRAY.get(i % 17), HexAndByteArray.ByteToHexUseLookUpTable2(StaticValue.BYTE_STRING_ARRAY.get(i % 17)));
        }
        end = System.currentTimeMillis();
        double resultTime = (end - start) / 1000.0;
        System.out.println("lookup table(HashMap) ��� ��ȯ �ð� : " + resultTime);
    }
}
