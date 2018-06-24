package tlvparser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubivelox.gaia.GaiaException;
import com.ubivelox.gaia.util.GaiaUtils;

import exception.UbiveloxException;

public class TlvParserTest
{

    private static final Logger logger = LoggerFactory.getLogger(TlvParserTest.class);





    @Test
    public void test() throws UbiveloxException, GaiaException
    {
        TlvParser2 tl = new TlvParser2();

        assertEquals("01\t01\t01\n02\t01\t02", tl.parse("010101020102"));
        assertEquals("01\t01\t01", tl.parse("010101"));
        assertEquals("1F01\t8102\t0303", tl.parse("1F0181020303"));
        assertEquals("01\t01\t01", tl.parse("010101"));
        assertEquals("1F01\t810A\t0102030405060708090A", tl.parse("1F01810A0102030405060708090A"));
        assertEquals("1F01\t8109\t010203040506070809", tl.parse("1F018109010203040506070809"));
        assertEquals("1F01\t8108\t0102030405060708", tl.parse("1F0181080102030405060708"));
        assertEquals("1F01\t8107\t01020304050607", tl.parse("1F01810701020304050607"));
        assertEquals("1F01\t8106\t010203040506", tl.parse("1F018106010203040506"));
        assertEquals("1F01\t8104\t01020304", tl.parse("1F01810401020304"));
        assertEquals("1F01\t8103\t010203", tl.parse("1F018103010203"));
        assertEquals("1F01\t8102\t0102", tl.parse("1F0181020102"));
        assertEquals("1F05\t8101\t11", tl.parse("1F05810111"));
        assertEquals("DF05\t8101\t11", tl.parse("DF05810111"));
        assertEquals("1F05\t8101\t11", tl.parse("1F05810111"));
        assertEquals("1F05\t8101\t11", tl.parse("1F05810111"));
        assertEquals("1F05\t8101\t11", tl.parse("1F05810111"));
        assertEquals("1F05\t8101\t11", tl.parse("1F05810111"));
        assertEquals("1F05\t8101\t11", tl.parse("1F05810111"));
        assertEquals("1F05\t8101\t11", tl.parse("1F05810111"));
        assertEquals("1F01\t8101\t01", tl.parse("1F01810101"));
        assertEquals("1F01\t8101\t01", tl.parse("1F01810101"));
        assertEquals("1F03\t03\t111111", tl.parse("1F0303111111"));
        assertEquals("DF03\t03\t111111", tl.parse("DF0303111111"));
        assertEquals("1F03\t03\t111111", tl.parse("1F0303111111"));
        assertEquals("1F03\t03\t111111", tl.parse("1F0303111111"));
        assertEquals("1F03\t03\t111111", tl.parse("1F0303111111"));
        assertEquals("1F03\t03\t111111", tl.parse("1F0303111111"));
        assertEquals("1F01\t01\t11", tl.parse("1F010111"));
        assertEquals("1F01\t01\t11", tl.parse("1F010111"));
        assertEquals("1F01\t01\t11", tl.parse("1F010111"));
        assertEquals("01\t01\t11", tl.parse("010111"));
        assertEquals("1F01\t8101\t01", tl.parse("1F01810101"));
        assertEquals("01\t8101\t01", tl.parse("01810101"));
        assertEquals("1F01\t8101\t01", tl.parse("1F01810101"));
        assertEquals("01\t8101\t01", tl.parse("01810101"));
        assertEquals("01\t02\t0101", tl.parse("01020101"));
        assertEquals("01\t01\t01", tl.parse("010101"));
        assertEquals("1F01\t01\t02", tl.parse("1F010102"));
        assertEquals("1F70\t01\t02", tl.parse("1F700102"));
        assertEquals("1F00\t01\t02", tl.parse("1F000102"));
        assertEquals("1F01\t01\t02", tl.parse("1F010102"));
        assertEquals("1F01\t01\tFF", tl.parse("1f0101ff"));
        assertEquals("05\t01\tFF", tl.parse("0501ff"));
        assertEquals("03\t01\t02", tl.parse("030102"));
        assertEquals("03\t01\t01", tl.parse("030101"));
        assertEquals("04\t01\t01", tl.parse("040101"));
        assertEquals("03\t01\t01", tl.parse("030101"));
        assertEquals("02\t01\t01", tl.parse("020101"));
        assertEquals("01\t01\t01", tl.parse("010101"));
        assertEquals("1F01\t00", tl.parse("1F0100"));
        assertEquals("DF01\t00", tl.parse("DF0100"));
        assertEquals("BF01\t00", tl.parse("BF0100"));
        assertEquals("7F01\t00", tl.parse("7F0100"));
        assertEquals("5F01\t00", tl.parse("5F0100"));
        assertEquals("3F01\t00", tl.parse("3F0100"));
        assertEquals("1F01\t00", tl.parse("1F0100"));
        assertEquals("EF\t00", tl.parse("EF00"));
        assertEquals("CF\t00", tl.parse("CF00"));
        assertEquals("AF\t00", tl.parse("AF00"));
        assertEquals("8F\t00", tl.parse("8F00"));
        assertEquals("6F\t00", tl.parse("6F00"));
        assertEquals("4F\t00", tl.parse("4F00"));
        assertEquals("2F\t00", tl.parse("2F00"));
        assertEquals("01\t00", tl.parse("0100"));
        assertEquals("01\t00\n02\t00", tl.parse("01000200"));
        assertEquals("21\t03\n\t01\t01\t01", tl.parse("2103010101"));
        assertEquals("1F01\t810A\t0102030405060708090A\n04\t03\t010101\n01\t01\t03\n01\t00\n01\t01\t02\n01\t01\t03\n01\t01\t02\n01\t01\t02\n01\t00\n02\t00\n03\t00\n04\t03\t010101",
                     tl.parse("1F01810A0102030405060708090A040301010101010301000101020101030101020101020100020003000403010101"));
        assertEquals("1F01\t810A\t0102030405060708090A\n04\t03\t010101", tl.parse("1F01810A0102030405060708090A0403010101"));
        assertEquals("01\t01\t03\n01\t00\n01\t01\t02", tl.parse("0101030100010102"));
        assertEquals("01\t01\t03\n01\t01\t02\n01\t01\t02", tl.parse("010103010102010102"));
        assertEquals("01\t00\n02\t00\n03\t00\n04\t03\t010101", tl.parse("0100020003000403010101"));
        assertEquals("01\t00\n02\t00\n03\t00", tl.parse("010002000300"));
        assertEquals("21\t05\n\t21\t03\n\t\t01\t01\t01\n21\t05\n\t21\t03\n\t\t02\t01\t01", tl.parse("2105210301010121052103020101"));
        assertEquals("21\t05\n\t21\t03\n\t\t01\t01\t01\n21\t05\n\t21\t03\n\t\t01\t01\t01\n21\t05\n\t21\t03\n\t\t01\t01\t01", tl.parse("210521030101012105210301010121052103010101"));
        assertEquals("21\t03\n\t01\t01\t01", tl.parse("2103010101"));
        assertEquals("21\t05\n\t21\t03\n\t\t01\t01\t01", tl.parse("21052103010101"));
        assertEquals("21\t15\n\t21\t05\n\t\t21\t03\n\t\t\t01\t01\t01\n\t21\t05\n\t\t21\t03\n\t\t\t01\t01\t01\n\t21\t05\n\t\t21\t03\n\t\t\t01\t01\t01",
                     tl.parse("2115210521030101012105210301010121052103010101"));
        //
        //
        // assertEquals("21\t15\n\t21\t05\n\t\t21\t03\n\t\t\t01\t01\t01\n\t21\t05\n\t\t21\t03\n\t\t\t01\t01\t01\n\t21\t05\n\t\t21\t03\n\t\t\t01\t01\t01\n21\t15\n\t21\t05\n\t\t21\t03\n\t\t\t01\t01\t01\n\t21\t05\n\t\t21\t03\n\t\t\t01\t01\t01\n\t21\t05\n\t\t21\t03\n\t\t\t01\t01\t01",
        // tl.parse("21152105210301010121052103010101210521030101012115210521030101012105210301010121052103010101"));
        // assertEquals("6F\t6F\n\t84\t08\tA000000003000000\n\tA5\t59\n\t\t9F65\t01\tFF\n\t\t9F6E\t06\t479173512E00\n\t\t73\t4A\n\t\t\t06\t07\t2A864886FC6B01\n\t\t\t60\t0C\n\t\t\t\t06\t0A\t2A864886FC6B02020101\n\t\t\t63\t09\n\t\t\t\t06\t07\t2A864886FC6B03\n\t\t\t64\t0B\n\t\t\t\t06\t09\t2A864886FC6B040215\n\t\t\t65\t0B\n\t\t\t\t06\t09\t2B8510864864020103\n\t\t\t66\t0C\n\t\t\t\t06\t0A\t2B060104012A026E0102\n\t84\t08\tA000000003000000\n6F\t6F\n\t84\t08\tA000000003000000\n\tA5\t59\n\t\t9F65\t01\tFF\n\t\t9F6E\t06\t479173512E00\n\t\t73\t4A\n\t\t\t06\t07\t2A864886FC6B01\n\t\t\t60\t0C\n\t\t\t\t06\t0A\t2A864886FC6B02020101\n\t\t\t63\t09\n\t\t\t\t06\t07\t2A864886FC6B03\n\t\t\t64\t0B\n\t\t\t\t06\t09\t2A864886FC6B040215\n\t\t\t65\t0B\n\t\t\t\t06\t09\t2B8510864864020103\n\t\t\t66\t0C\n\t\t\t\t06\t0A\t2B060104012A026E0102\n\t84\t08\tA000000003000000",
        // tl.parse("6F6F8408A000000003000000A5599F6501FF9F6E06479173512E00734A06072A864886FC6B01600C060A2A864886FC6B02020101630906072A864886FC6B03640B06092A864886FC6B040215650B06092B8510864864020103660C060A2B060104012A026E01028408A0000000030000006F6F8408A000000003000000A5599F6501FF9F6E06479173512E00734A06072A864886FC6B01600C060A2A864886FC6B02020101630906072A864886FC6B03640B06092A864886FC6B040215650B06092B8510864864020103660C060A2B060104012A026E01028408A000000003000000"));

    }





    @Test
    public void testException() throws UbiveloxException, GaiaException
    {

        /*
         * parse
         */

        parseException("", "3F01810A0102030405060708090A0403010101010103010001010201010301010201010201000200030004030101013F01810201", "Value Range is not enough");
        parseException("", "3F01810201", "Value Range is not enough");
        parseException("", "2F0201", "Value Range is not enough");
        parseException("", "010201", "Value Range is not enough");
        parseException("", "010201", "Value Range is not enough");
        parseException("", "1FFF010102", "Tag Range Overflow");
        parseException("", "FFFF010102", "Tag Range Overflow");
        parseException("", "FF80010102", "Tag Range Overflow");
        parseException("", "DFFF010102", "Tag Range Overflow");
        parseException("", "DFF0010102", "Tag Range Overflow");
        parseException("", "BFFF010102", "Tag Range Overflow");
        parseException("", "BFE0010102", "Tag Range Overflow");
        parseException("", "9FFF010102", "Tag Range Overflow");
        parseException("", "9FD0010102", "Tag Range Overflow");
        parseException("", "7FFF010102", "Tag Range Overflow");
        parseException("", "7FC0010102", "Tag Range Overflow");
        parseException("", "5FFF010102", "Tag Range Overflow");
        parseException("", "5FB0010102", "Tag Range Overflow");
        parseException("", "3FFF010102", "Tag Range Overflow");
        parseException("", "3FA1010102", "Tag Range Overflow");
        parseException("", "1FFF010102", "Tag Range Overflow");
        parseException("", "1F80010102", "Tag Range Overflow");
        parseException("", "FF0181", "Length is not enough");
        parseException("", "DF0181", "Length is not enough");
        parseException("", "BF0181", "Length is not enough");
        parseException("", "9F0181", "Length is not enough");
        parseException("", "7F0181", "Length is not enough");
        parseException("", "5F0181", "Length is not enough");
        parseException("", "3F0181", "Length is not enough");
        parseException("", "1F0181", "Length is not enough");
        parseException("", "0181", "Length is not enough");
        parseException("", "FF0182", "Length Range Overflow");
        parseException("", "DF0184", "Length Range Overflow");
        parseException("", "BF0183", "Length Range Overflow");
        parseException("", "9F0182", "Length Range Overflow");
        parseException("", "7F0184", "Length Range Overflow");
        parseException("", "5F0183", "Length Range Overflow");
        parseException("", "3F0182", "Length Range Overflow");
        parseException("", "1F0182", "Length Range Overflow");
        parseException("", "EF82", "Length Range Overflow");
        parseException("", "CF82", "Length Range Overflow");
        parseException("", "AF82", "Length Range Overflow");
        parseException("", "8F82", "Length Range Overflow");
        parseException("", "6F82", "Length Range Overflow");
        parseException("", "4F82", "Length Range Overflow");
        parseException("", "2F82", "Length Range Overflow");
        parseException("", "0183", "Length Range Overflow");
        parseException("", "0184", "Length Range Overflow");
        parseException("", "3F0182010101", "Length Range Overflow");
        parseException("", "1F0182010101", "Length Range Overflow");
        parseException("", "0382010101", "Length Range Overflow");
        parseException("", "0282010101", "Length Range Overflow");
        parseException("", "0182010101", "Length Range Overflow");
        parseException("", "ff01ff01", "Length Range Overflow");
        parseException("", "EF", "Length Range is not exist");
        parseException("", "CF", "Length Range is not exist");
        parseException("", "AF", "Length Range is not exist");
        parseException("", "0C", "Length Range is not exist");
        parseException("", "0A", "Length Range is not exist");
        parseException("", "06", "Length Range is not exist");
        parseException("", "03", "Length Range is not exist");
        parseException("", "02", "Length Range is not exist");
        parseException("", "01", "Length Range is not exist");
        parseException("", "FF03", "Length Range is not exist");
        parseException("", "DF03", "Length Range is not exist");
        parseException("", "BF03", "Length Range is not exist");
        parseException("", "9F03", "Length Range is not exist");
        parseException("", "7F03", "Length Range is not exist");
        parseException("", "5F03", "Length Range is not exist");
        parseException("", "3F05", "Length Range is not exist");
        parseException("", "1F01", "Length Range is not exist");
        parseException("", "FF028101", "Value Range is not exist");
        parseException("", "DF028101", "Value Range is not exist");
        parseException("", "BF028101", "Value Range is not exist");
        parseException("", "9F028101", "Value Range is not exist");
        parseException("", "7F028101", "Value Range is not exist");
        parseException("", "5F028101", "Value Range is not exist");
        parseException("", "3F028101", "Value Range is not exist");
        parseException("", "1F028101", "Value Range is not exist");
        parseException("", "FF0201", "Value Range is not exist");
        parseException("", "DF0201", "Value Range is not exist");
        parseException("", "BF0201", "Value Range is not exist");
        parseException("", "9F0201", "Value Range is not exist");
        parseException("", "7F0201", "Value Range is not exist");
        parseException("", "5F0201", "Value Range is not exist");
        parseException("", "3F0201", "Value Range is not exist");
        parseException("", "1F0201", "Value Range is not exist");
        parseException("", "1F0180", "Value Range is not exist");
        parseException("", "1F0180", "Value Range is not exist");
        parseException("", "1F0180", "Value Range is not exist");
        parseException("", "1F0180", "Value Range is not exist");
        parseException("", "1F0101", "Value Range is not exist");
        parseException("", "1F0180", "Value Range is not exist");
        parseException("", "0E01", "Value Range is not exist");
        parseException("", "0D01", "Value Range is not exist");
        parseException("", "0C01", "Value Range is not exist");
        parseException("", "0B01", "Value Range is not exist");
        parseException("", "0A01", "Value Range is not exist");
        parseException("", "0180", "Value Range is not exist");
        parseException("", "", "Target objects[0] is empty String.");

        /*
         * Tag
         */
        getTagSizeException(null, "Target objects[0] is null.");
        getTagSizeException(new byte[0], "Target objects[0] is empty byte[].");

        /*
         * Length
         */
        getLengthSizeException(null, "Target objects[0] is null.");
        getLengthSizeException(new byte[0], "Target objects[0] is empty byte[].");

        /*
         * HexString
         */
        HexToByteException(null, "Target objects[0] is null.");
        HexToByteException("", "Target objects[0] is empty String.");
        HexToByteException("abc", "args[0] is invalid. string length[3] is not even.");
        HexToByteException("abcde", "args[0] is invalid. string length[5] is not even.");
        HexToByteException("abccccc", "args[0] is invalid. string length[7] is not even.");
        HexToByteException("abc123452", "args[0] is invalid. string length[9] is not even.");
        HexToByteException("1231235A3bC", "args[0] is invalid. string length[11] is not even.");
        HexToByteException("1231235AbCbab", "args[0] is invalid. string length[13] is not even.");

    }





    private void getLengthSizeException(final byte[] byteArray, final String errorMessage)
    {
        try
        {
            TLVParser.getLengthSize(byteArray, 0);
            fail();
        }
        catch ( UbiveloxException e )
        {
            assertEquals(errorMessage, e.getMessage());
        }
        catch ( GaiaException e )
        {
            assertEquals(errorMessage, e.getMessage());
        }
    }





    private void getTagSizeException(final byte[] byteArray, final String errorMessage)
    {
        try
        {
            TLVParser.getTagSize(byteArray, 0);
            fail();
        }
        catch ( UbiveloxException e )
        {
            assertEquals(errorMessage, e.getMessage());
        }
        catch ( GaiaException e )
        {
            assertEquals(errorMessage, e.getMessage());
        }
    }





    private void HexToByteException(final String outputString, final String errorMessage)
    {
        try
        {
            GaiaUtils.convertHexaStringToByteArray(outputString);
            fail();
        }
        catch ( GaiaException e )
        {
            assertEquals(errorMessage, e.getMessage());
        }
    }





    private void parseException(final String outputString, final String hexStr, final String errorMessage)
    {
        try
        {
            assertEquals(outputString, TLVParser.parse(hexStr));
            fail();
        }
        catch ( UbiveloxException e )
        {
            assertEquals(errorMessage, e.getMessage());
        }
        catch ( GaiaException e )
        {
            assertEquals(errorMessage, e.getMessage());
        }
    }

}
