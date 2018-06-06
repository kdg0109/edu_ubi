package tlvparser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.ubivelox.gaia.GaiaException;

import exception.UbiveloxException;

public class TLVParserWithArrayListTest
{

    public static class TLVObject
    {
        String               tag;
        String               length;
        ArrayList<TLVObject> value;
        String               stringValue;





        public TLVObject(final String tag, final String length)
        {
            this.tag = tag;
            this.length = length;
            this.stringValue = "";
        }





        public TLVObject(final String tag, final String length, final String stringValue)
        {
            this.tag = tag;
            this.length = length;
            this.stringValue = stringValue;
        }





        public TLVObject(final String tag, final String length, final ArrayList<TLVObject> arrayList)
        {
            this.tag = tag;
            this.length = length;
            this.value = arrayList;
        }





        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((this.length == null) ? 0 : this.length.hashCode());
            result = prime * result + ((this.stringValue == null) ? 0 : this.stringValue.hashCode());
            result = prime * result + ((this.tag == null) ? 0 : this.tag.hashCode());
            result = prime * result + ((this.value == null) ? 0 : this.value.hashCode());
            return result;
        }





        @Override
        public boolean equals(final Object obj)
        {
            if ( this == obj )
            {
                return true;
            }
            if ( obj == null )
            {
                return false;
            }
            if ( getClass() != obj.getClass() )
            {
                return false;
            }
            TLVObject other = (TLVObject) obj;
            if ( this.length == null )
            {
                if ( other.length != null )
                {
                    return false;
                }
            }
            else if ( !this.length.equals(other.length) )
            {
                return false;
            }
            if ( this.stringValue == null )
            {
                if ( other.stringValue != null )
                {
                    return false;
                }
            }
            else if ( !this.stringValue.equals(other.stringValue) )
            {
                return false;
            }
            if ( this.tag == null )
            {
                if ( other.tag != null )
                {
                    return false;
                }
            }
            else if ( !this.tag.equals(other.tag) )
            {
                return false;
            }
            if ( this.value == null )
            {
                if ( other.value != null )
                {
                    return false;
                }
            }
            else if ( !this.value.equals(other.value) )
            {
                return false;
            }
            return true;
        }





        public String getTag()
        {
            return this.tag;
        }





        public void setTag(final String tag)
        {
            this.tag = tag;
        }





        public String getLength()
        {
            return this.length;
        }





        public void setLength(final String length)
        {
            this.length = length;
        }





        public void setStringValue(final String stringValue)
        {
            this.stringValue = stringValue;
        }





        public String getStringValue()
        {
            return this.stringValue;
        }





        public ArrayList<TLVObject> getValue()
        {
            return this.value;
        }





        public void setValue(final ArrayList<TLVObject> value)
        {
            this.value = value;
        }

    }





    @Test
    public void test() throws UbiveloxException, GaiaException
    {
    	
    	assertEquals("6F\t6F\n\t84\t08\tA000000003000000\n\tA5\t59\n\t\t9F65\t01\tFF\n\t\t9F6E\t06\t479173512E00\n\t\t73\t4A\n\t\t\t06\t07\t2A864886FC6B01\n\t\t\t60\t0C\n\t\t\t\t06\t0A\t2A864886FC6B02020101\n\t\t\t63\t09\n\t\t\t\t06\t07\t2A864886FC6B03\n\t\t\t64\t0B\n\t\t\t\t06\t09\t2A864886FC6B040215\n\t\t\t65\t0B\n\t\t\t\t06\t09\t2B8510864864020103\n\t\t\t66\t0C\n\t\t\t\t06\t0A\t2B060104012A026E0102\n\t84\t08\tA000000003000000\n6F\t6F\n\t84\t08\tA000000003000000\n\tA5\t59\n\t\t9F65\t01\tFF\n\t\t9F6E\t06\t479173512E00\n\t\t73\t4A\n\t\t\t06\t07\t2A864886FC6B01\n\t\t\t60\t0C\n\t\t\t\t06\t0A\t2A864886FC6B02020101\n\t\t\t63\t09\n\t\t\t\t06\t07\t2A864886FC6B03\n\t\t\t64\t0B\n\t\t\t\t06\t09\t2A864886FC6B040215\n\t\t\t65\t0B\n\t\t\t\t06\t09\t2B8510864864020103\n\t\t\t66\t0C\n\t\t\t\t06\t0A\t2B060104012A026E0102\n\t84\t08\tA000000003000000",
    			TLVParserWithArrayList.parse("6F6F8408A000000003000000A5599F6501FF9F6E06479173512E00734A06072A864886FC6B01600C060A2A864886FC6B02020101630906072A864886FC6B03640B06092A864886FC6B040215650B06092B8510864864020103660C060A2B060104012A026E01028408A0000000030000006F6F8408A000000003000000A5599F6501FF9F6E06479173512E00734A06072A864886FC6B01600C060A2A864886FC6B02020101630906072A864886FC6B03640B06092A864886FC6B040215650B06092B8510864864020103660C060A2B060104012A026E01028408A000000003000000"));
    	assertEquals("21\t06\n\t21\t00\n\t21\t00\n\t21\t00", TLVParserWithArrayList.parse("2106210021002100"));
    	
    	assertEquals("21\t15\n\t21\t05\n\t\t21\t03\n\t\t\t01\t01\t01\n\t21\t05\n\t\t21\t03\n\t\t\t01\t01\t01\n\t21\t05\n\t\t21\t03\n\t\t\t01\t01\t01",
    			TLVParserWithArrayList.parse("2115210521030101012105210301010121052103010101"));
    	assertEquals("21\t05\n\t21\t03\n\t\t01\t01\t01\n21\t05\n\t21\t03\n\t\t01\t01\t01\n21\t05\n\t21\t03\n\t\t01\t01\t01", TLVParserWithArrayList.parse("210521030101012105210301010121052103010101"));
    	assertEquals("21\t05\n\t21\t03\n\t\t01\t01\t01\n21\t05\n\t21\t03\n\t\t01\t01\t01", TLVParserWithArrayList.parse("2105210301010121052103010101"));
    	assertEquals("21\t05\n\t21\t03\n\t\t01\t01\t01", TLVParserWithArrayList.parse("21052103010101"));
    	assertEquals("21\t03\n\t01\t01\t01", TLVParserWithArrayList.parse("2103010101"));
    	
    	assertEquals("1F01\t810A\t0102030405060708090A\n04\t03\t010101", TLVParserWithArrayList.parse("1F01810A0102030405060708090A0403010101"));
    	assertEquals("01\t01\t03\n01\t00\n01\t01\t02", TLVParserWithArrayList.parse("0101030100010102"));
    	assertEquals("01\t01\t03\n01\t01\t02\n01\t01\t02", TLVParserWithArrayList.parse("010103010102010102"));
    	assertEquals("01\t00\n02\t00\n03\t00\n04\t03\t010101", TLVParserWithArrayList.parse("0100020003000403010101"));
    	assertEquals("01\t00\n02\t00\n03\t00", TLVParserWithArrayList.parse("010002000300"));
    	assertEquals("01\t00\n02\t00", TLVParserWithArrayList.parse("01000200"));
    	assertEquals("01\t01\t01\n02\t01\t02", TLVParserWithArrayList.parse("010101020102"));
    	assertEquals("1F01\t810A\t0102030405060708090A", TLVParserWithArrayList.parse("1F01810A0102030405060708090A"));
    	assertEquals("1F01\t8109\t010203040506070809", TLVParserWithArrayList.parse("1F018109010203040506070809"));
    	assertEquals("1F01\t8108\t0102030405060708", TLVParserWithArrayList.parse("1F0181080102030405060708"));
    	assertEquals("1F01\t8107\t01020304050607", TLVParserWithArrayList.parse("1F01810701020304050607"));
    	assertEquals("1F01\t8106\t010203040506", TLVParserWithArrayList.parse("1F018106010203040506"));
//   // assertEquals("3F01\t8103\t010203", TLVParserWithArrayList.parse("3F0181030102030405"));
    	assertEquals("1F01\t8104\t01020304", TLVParserWithArrayList.parse("1F01810401020304"));
    	assertEquals("1F01\t8103\t010203", TLVParserWithArrayList.parse("1F018103010203"));
    	assertEquals("1F01\t8102\t0102", TLVParserWithArrayList.parse("1F0181020102"));
    	assertEquals("1F05\t8101\t11", TLVParserWithArrayList.parse("1F05810111"));
    	assertEquals("1F05\t8101\t11", TLVParserWithArrayList.parse("1F05810111"));
    	assertEquals("1F05\t8101\t11", TLVParserWithArrayList.parse("1F05810111"));
    	assertEquals("1F05\t8101\t11", TLVParserWithArrayList.parse("1F05810111"));
    	assertEquals("1F05\t8101\t11", TLVParserWithArrayList.parse("1F05810111"));
    	assertEquals("1F05\t8101\t11", TLVParserWithArrayList.parse("1F05810111"));
    	assertEquals("1F05\t8101\t11", TLVParserWithArrayList.parse("1F05810111"));
    	assertEquals("1F05\t8101\t11", TLVParserWithArrayList.parse("1F05810111"));
    	assertEquals("1F01\t8101\t01", TLVParserWithArrayList.parse("1F01810101"));
    	assertEquals("1F01\t8101\t01", TLVParserWithArrayList.parse("1F01810101"));
    	assertEquals("DF03\t03\t111111", TLVParserWithArrayList.parse("DF0303111111"));
    	assertEquals("9F03\t03\t111111", TLVParserWithArrayList.parse("9F0303111111"));
    	assertEquals("5F03\t03\t111111", TLVParserWithArrayList.parse("5F0303111111"));
    	assertEquals("4F\t03\t111111", TLVParserWithArrayList.parse("4F03111111"));
    	assertEquals("1F03\t03\t111111", TLVParserWithArrayList.parse("1F0303111111"));
    	assertEquals("DF01\t01\t11", TLVParserWithArrayList.parse("DF010111"));
    	assertEquals("9F01\t01\t11", TLVParserWithArrayList.parse("9F010111"));
    	assertEquals("1F01\t01\t11", TLVParserWithArrayList.parse("1F010111"));
    	assertEquals("01\t01\t11", TLVParserWithArrayList.parse("010111"));
    	assertEquals("1F01\t8101\t01", TLVParserWithArrayList.parse("1F01810101"));
    	assertEquals("1F01\t8101\t01", TLVParserWithArrayList.parse("1F01810101"));
    	assertEquals("1F01\t8101\t01", TLVParserWithArrayList.parse("1F01810101"));
    	assertEquals("01\t8101\t01", TLVParserWithArrayList.parse("01810101"));
    	assertEquals("01\t02\t0101", TLVParserWithArrayList.parse("01020101"));
    	assertEquals("01\t01\t01", TLVParserWithArrayList.parse("010101"));
    	assertEquals("1F01\t01\t02", TLVParserWithArrayList.parse("1F010102"));
    	assertEquals("1F70\t01\t02", TLVParserWithArrayList.parse("1F700102"));
    	assertEquals("1F00\t01\t02", TLVParserWithArrayList.parse("1F000102"));
    	assertEquals("1F01\t01\t02", TLVParserWithArrayList.parse("1F010102"));
    	assertEquals("1F01\t01\tFF", TLVParserWithArrayList.parse("1F0101FF"));
    	assertEquals("05\t01\tFF", TLVParserWithArrayList.parse("0501FF"));
    	assertEquals("03\t01\t02", TLVParserWithArrayList.parse("030102"));
    	assertEquals("03\t01\t01", TLVParserWithArrayList.parse("030101"));
    	assertEquals("04\t01\t01", TLVParserWithArrayList.parse("040101"));
    	assertEquals("03\t01\t01", TLVParserWithArrayList.parse("030101"));
    	assertEquals("02\t01\t01", TLVParserWithArrayList.parse("020101"));
    	assertEquals("01\t01\t01", TLVParserWithArrayList.parse("010101"));
    	assertEquals("DF01\t00", TLVParserWithArrayList.parse("DF0100"));
    	assertEquals("BF01\t00", TLVParserWithArrayList.parse("BF0100"));
    	assertEquals("9F01\t00", TLVParserWithArrayList.parse("9F0100"));
    	assertEquals("7F01\t00", TLVParserWithArrayList.parse("7F0100"));
    	assertEquals("5F01\t00", TLVParserWithArrayList.parse("5F0100"));
    	assertEquals("3F01\t00", TLVParserWithArrayList.parse("3F0100"));
    	assertEquals("1F01\t00", TLVParserWithArrayList.parse("1F0100"));
    	assertEquals("EF\t00", TLVParserWithArrayList.parse("EF00"));
    	assertEquals("CF\t00", TLVParserWithArrayList.parse("CF00"));
    	assertEquals("AF\t00", TLVParserWithArrayList.parse("AF00"));
    	assertEquals("8F\t00", TLVParserWithArrayList.parse("8F00"));
    	assertEquals("6F\t00", TLVParserWithArrayList.parse("6F00"));
    	assertEquals("4F\t00", TLVParserWithArrayList.parse("4F00"));
    	assertEquals("2F\t00", TLVParserWithArrayList.parse("2F00"));
    	assertEquals("01\t00", TLVParserWithArrayList.parse("0100"));

    	
//        ArrayList<TLVObject> tlvExpectedList = new ArrayList<>();
//        ArrayList<TLVObject> tlvExpectedListDepth1 = new ArrayList<>();
//
//      //@formatter:off
//        ArrayList<TLVObject> tlvList = new ArrayList<>(Arrays.asList(
//          new TLVObject("6F", "6F", new ArrayList<>(Arrays.asList(
//                        new TLVObject("84", "08", "A000000003000000")
//                      , new TLVObject("A5", "59", new ArrayList<>(Arrays.asList(
//                                      new TLVObject("9F65", "01", "FF")
//                                    , new TLVObject("9F6E", "06", "479173512E00")
//                                    , new TLVObject("73", "4A", new ArrayList<>(Arrays.asList(
//                                                    new TLVObject("06", "07", "2A864886FC6B01")
//                                                  , new TLVObject("60", "0C", new ArrayList<>(Arrays.asList(
//                                                                  new TLVObject("06", "0A", "2A864886FC6B02020101"))))
//                                                  , new TLVObject("63", "09", new ArrayList<>(Arrays.asList(
//                                                                  new TLVObject("06", "07", "2A864886FC6B03"))))
//                                                  , new TLVObject("64", "0B", new ArrayList<>(Arrays.asList(
//                                                                  new TLVObject("06", "09", "2A864886FC6B040215"))))
//                                                  , new TLVObject("65", "0B", new ArrayList<>(Arrays.asList(
//                                                                  new TLVObject("06", "09", "2B8510864864020103"))))
//                                                  , new TLVObject("66", "0C", new ArrayList<>(Arrays.asList(
//                                                                  new TLVObject("06", "0A", "2B060104012A026E0102"))))
//                                                   )))
//                                          )))
//                      , new TLVObject("84", "08", "A000000003000000"))
//                  )), 
//          new TLVObject("6F", "6F", new ArrayList<>(Arrays.asList(
//                  new TLVObject("84", "08", "A000000003000000")
//                , new TLVObject("A5", "59", new ArrayList<>(Arrays.asList(
//                                new TLVObject("9F65", "01", "FF")
//                              , new TLVObject("9F6E", "06", "479173512E00")
//                              , new TLVObject("73", "4A", new ArrayList<>(Arrays.asList(
//                                              new TLVObject("06", "07", "2A864886FC6B01")
//                                            , new TLVObject("60", "0C", new ArrayList<>(Arrays.asList(
//                                                            new TLVObject("06", "0A", "2A864886FC6B02020101"))))
//                                            , new TLVObject("63", "09", new ArrayList<>(Arrays.asList(
//                                                            new TLVObject("06", "07", "2A864886FC6B03"))))
//                                            , new TLVObject("64", "0B", new ArrayList<>(Arrays.asList(
//                                                            new TLVObject("06", "09", "2A864886FC6B040215"))))
//                                            , new TLVObject("65", "0B", new ArrayList<>(Arrays.asList(
//                                                            new TLVObject("06", "09", "2B8510864864020103"))))
//                                            , new TLVObject("66", "0C", new ArrayList<>(Arrays.asList(
//                                                            new TLVObject("06", "0A", "2B060104012A026E0102"))))
//                                             )))
//                                    )))
//                , new TLVObject("84", "08", "A000000003000000"))
//            ))));
//
//
//        //@formatter:on
//
//        assertEquals(tlvList,
//                     TLVParserWithArrayList.parse("6F6F8408A000000003000000A5599F6501FF9F6E06479173512E00734A06072A864886FC6B01600C060A2A864886FC6B02020101630906072A864886FC6B03640B06092A864886FC6B040215650B06092B8510864864020103660C060A2B060104012A026E01028408A000000003000000"
//                                                  + "6F6F8408A000000003000000A5599F6501FF9F6E06479173512E00734A06072A864886FC6B01600C060A2A864886FC6B02020101630906072A864886FC6B03640B06092A864886FC6B040215650B06092B8510864864020103660C060A2B060104012A026E01028408A000000003000000"));
//
//        tlvExpectedListDepth1.add(new TLVObject("01", "01", "01"));
//        tlvExpectedList.add(new TLVObject("21", "03", tlvExpectedListDepth1));
//        assertEquals(tlvExpectedList, TLVParserWithArrayList.parse("2103010101"));
//
//        tlvExpectedList.clear();
//        tlvExpectedListDepth1.clear();
//
//        tlvExpectedList.add(new TLVObject("01", "01", "03"));
//        tlvExpectedList.add(new TLVObject("01", "01", "02"));
//        tlvExpectedList.add(new TLVObject("01", "01", "02"));
//        assertEquals(tlvExpectedList, TLVParserWithArrayList.parse("010103010102010102"));
//
//        tlvExpectedList.clear();
//
//        tlvExpectedList.add(new TLVObject("01", "00"));
//        tlvExpectedList.add(new TLVObject("02", "00"));
//        tlvExpectedList.add(new TLVObject("03", "00"));
//        assertEquals(tlvExpectedList, TLVParserWithArrayList.parse("010002000300"));
//
//        tlvExpectedList.clear();
//
//        tlvExpectedList.add(new TLVObject("01", "00"));
//        tlvExpectedList.add(new TLVObject("02", "00"));
//        assertEquals(tlvExpectedList, TLVParserWithArrayList.parse("01000200"));
//
//        tlvExpectedList.clear();
//
//        tlvExpectedList.add(new TLVObject("1F01", "8104", "01020304"));
//        assertEquals(tlvExpectedList, TLVParserWithArrayList.parse("1F01810401020304"));
//
//        tlvExpectedList.clear();
//
//        tlvExpectedList.add(new TLVObject("1F03", "03", "111111"));
//        assertEquals(tlvExpectedList, TLVParserWithArrayList.parse("1F0303111111"));
//
//        tlvExpectedList.clear();
//
//        tlvExpectedList.add(new TLVObject("1f01", "01", "ff"));
//        assertEquals(tlvExpectedList, TLVParserWithArrayList.parse("1f0101ff"));
//
//        tlvExpectedList.clear();
//
//        tlvExpectedList.add(new TLVObject("1F01", "00"));
//        assertEquals(tlvExpectedList, TLVParserWithArrayList.parse("1F0100"));
//
//        tlvExpectedList.clear();
//
//        tlvExpectedList.add(new TLVObject("AF", "00"));
//        assertEquals(tlvExpectedList, TLVParserWithArrayList.parse("AF00"));
//
//        tlvExpectedList.clear();
//
//        tlvExpectedList.add(new TLVObject("01", "01", "01"));
//        assertEquals(tlvExpectedList, TLVParserWithArrayList.parse("010101"));

        

//        tlvList.clear();
//        tlvList.add(new TLVObject("01", "00"));
//        assertEquals(tlvList, TLVParserWithArrayList.parse("0100"));
//        
//        tlvList.clear();
//        tlvList.add(new TLVObject("01", "00"));
//        assertEquals(tlvList, TLVParserWithArrayList.parse("0100"));
    }





    @Test
    public void testException() throws UbiveloxException, GaiaException
    {

        /*
         * parse
         */

        parseException("", "3F01810A0102030405060708090A04030101013F01810201", "Value Range is not enough");

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
        parseException("", "FF01FF01", "Length Range Overflow");
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

    }





    private void getLengthSizeException(final byte[] byteArray, final String errorMessage)
    {
        try
        {
            TLVParserWithArrayList.getLengthSize(byteArray, 0);
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
            TLVParserWithArrayList.getTagSize(byteArray, 0);
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





    private void parseException(final String outputString, final String hexStr, final String errorMessage)
    {
        try
        {
            assertEquals(outputString, TLVParserWithArrayList.parse(hexStr));
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
