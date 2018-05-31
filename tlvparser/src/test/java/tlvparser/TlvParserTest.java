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
        assertEquals("3F01\t8102\t0102", TLVParser.parse("3F0181020102"));
        assertEquals("FF05\t8101\t11", TLVParser.parse("FF05810111"));
        assertEquals("DF05\t8101\t11", TLVParser.parse("DF05810111"));
        assertEquals("BF05\t8101\t11", TLVParser.parse("BF05810111"));
        assertEquals("9F05\t8101\t11", TLVParser.parse("9F05810111"));
        assertEquals("7F05\t8101\t11", TLVParser.parse("7F05810111"));
        assertEquals("5F05\t8101\t11", TLVParser.parse("5F05810111"));
        assertEquals("3F05\t8101\t11", TLVParser.parse("3F05810111"));
        assertEquals("1F05\t8101\t11", TLVParser.parse("1F05810111"));
        assertEquals("3F01\t8101\t01", TLVParser.parse("3F01810101"));
        assertEquals("1F01\t8101\t01", TLVParser.parse("1F01810101"));
        assertEquals("FF05\t11\t11", TLVParser.parse("FF051111"));
        assertEquals("DF05\t11\t11", TLVParser.parse("DF051111"));
        assertEquals("BF05\t11\t11", TLVParser.parse("BF051111"));
        assertEquals("9F05\t11\t11", TLVParser.parse("9F051111"));
        assertEquals("7F05\t11\t11", TLVParser.parse("7F051111"));
        assertEquals("5F05\t11\t11", TLVParser.parse("5F051111"));
        assertEquals("EF\t05\t11", TLVParser.parse("EF0511"));
        assertEquals("CF\t05\t11", TLVParser.parse("CF0511"));
        assertEquals("AF\t05\t11", TLVParser.parse("AF0511"));
        assertEquals("01\t05\t11", TLVParser.parse("010511"));
        assertEquals("EF\t8101\t01", TLVParser.parse("EF810101"));
        assertEquals("CF\t8101\t01", TLVParser.parse("CF810101"));
        assertEquals("AF\t8101\t01", TLVParser.parse("AF810101"));
        assertEquals("01\t8101\t01", TLVParser.parse("01810101"));
        assertEquals("01\t80\t0101", TLVParser.parse("01800101"));
        assertEquals("01\t80\t01", TLVParser.parse("018001"));
        assertEquals("3F01\t01\t02", TLVParser.parse("3F010102"));
        assertEquals("1F70\t80\t02", TLVParser.parse("1F708002"));
        assertEquals("1F70\t01\t02", TLVParser.parse("1F700102"));
        assertEquals("1F00\t01\t02", TLVParser.parse("1F000102"));
        assertEquals("1F01\t01\t02", TLVParser.parse("1F010102"));
        assertEquals("ff01\t01\tff", TLVParser.parse("ff0101ff"));
        assertEquals("05\t01\tff", TLVParser.parse("0501ff"));
        assertEquals("05\t0f\t01", TLVParser.parse("050f01"));
        assertEquals("03\t01\t02", TLVParser.parse("030102"));
        assertEquals("03\t01\t01", TLVParser.parse("030101"));
        assertEquals("04\t80\t01", TLVParser.parse("048001"));
        assertEquals("03\t80\t01", TLVParser.parse("038001"));
        assertEquals("02\t01\t01", TLVParser.parse("020101"));
        assertEquals("01\t01\t01", TLVParser.parse("010101"));
        assertEquals("FF01\t00", TLVParser.parse("FF0100"));
        assertEquals("DF01\t00", TLVParser.parse("DF0100"));
        assertEquals("BF01\t00", TLVParser.parse("BF0100"));
        assertEquals("7F01\t00", TLVParser.parse("7F0100"));
        assertEquals("5F01\t00", TLVParser.parse("5F0100"));
        assertEquals("3F01\t00", TLVParser.parse("3F0100"));
        assertEquals("1F01\t00", TLVParser.parse("1F0100"));
        assertEquals("EF\t00", TLVParser.parse("EF00"));
        assertEquals("CF\t00", TLVParser.parse("CF00"));
        assertEquals("AF\t00", TLVParser.parse("AF00"));
        assertEquals("8F\t00", TLVParser.parse("8F00"));
        assertEquals("6F\t00", TLVParser.parse("6F00"));
        assertEquals("4F\t00", TLVParser.parse("4F00"));
        assertEquals("2F\t00", TLVParser.parse("2F00"));
        assertEquals("01\t00", TLVParser.parse("0100"));
    }





    @Test
    public void testException() throws UbiveloxException, GaiaException
    {

        /*
         * parse
         */
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
