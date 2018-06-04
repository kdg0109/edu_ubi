package tlvparser;

import static org.junit.Assert.assertEquals;

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
        ArrayList<TLVObject> tlvExpectedList = new ArrayList<>();
        ArrayList<TLVObject> tlvExpectedListDepth1 = new ArrayList<>();

      //@formatter:off
        ArrayList<TLVObject> List = new ArrayList<>(Arrays.asList(
          new TLVObject("6F", "6F", new ArrayList<>(Arrays.asList(
                        new TLVObject("84", "08", "A000000003000000")
                      , new TLVObject("A5", "59", new ArrayList<>(Arrays.asList(
                                      new TLVObject("9F65", "01", "FF")
                                    , new TLVObject("9F6E", "06", "479173512E00")
                                    , new TLVObject("73", "4A", new ArrayList<>(Arrays.asList(
                                                    new TLVObject("06", "07", "2A864886FC6B01")
                                                  , new TLVObject("60", "0C", new ArrayList<>(Arrays.asList(
                                                                  new TLVObject("06", "0A", "2A864886FC6B02020101"))))
                                                  , new TLVObject("63", "09", new ArrayList<>(Arrays.asList(
                                                                  new TLVObject("06", "07", "2A864886FC6B03"))))
                                                  , new TLVObject("64", "0B", new ArrayList<>(Arrays.asList(
                                                                  new TLVObject("06", "09", "2A864886FC6B040215"))))
                                                  , new TLVObject("65", "0B", new ArrayList<>(Arrays.asList(
                                                                  new TLVObject("06", "09", "2B8510864864020103"))))
                                                  , new TLVObject("66", "0C", new ArrayList<>(Arrays.asList(
                                                                  new TLVObject("06", "0A", "2B060104012A026E0102"))))
                                                   )))
                                          )))
                      , new TLVObject("84", "08", "A000000003000000"))
                  ))
        ));


        List.add(new TLVObject("6F", "6F", new ArrayList<>(Arrays.asList(
                               new TLVObject("84", "08", "A000000003000000")
                             , new TLVObject("A5", "59", new ArrayList<>(Arrays.asList(
                                             new TLVObject("9F65", "01", "FF")
                                           , new TLVObject("9F6E", "06", "479173512E00")
                                           , new TLVObject("73", "4A", new ArrayList<>(Arrays.asList(
                                                           new TLVObject("06", "07", "2A864886FC6B01")
                                                         , new TLVObject("60", "0C", new ArrayList<>(Arrays.asList(
                                                                         new TLVObject("06", "0A", "2A864886FC6B02020101"))))
                                                         , new TLVObject("63", "09", new ArrayList<>(Arrays.asList(
                                                                         new TLVObject("06", "07", "2A864886FC6B03"))))
                                                         , new TLVObject("64", "0B", new ArrayList<>(Arrays.asList(
                                                                         new TLVObject("06", "09", "2A864886FC6B040215"))))
                                                         , new TLVObject("65", "0B", new ArrayList<>(Arrays.asList(
                                                                         new TLVObject("06", "09", "2B8510864864020103"))))
                                                         , new TLVObject("66", "0C", new ArrayList<>(Arrays.asList(
                                                                         new TLVObject("06", "0A", "2B060104012A026E0102"))))
                                              )))
                             )))
                             , new TLVObject("84", "08", "A000000003000000"))
                       )));
        //@formatter:on

        assertEquals(List,
                     TLVParserWithArrayList.parse("6F6F8408A000000003000000A5599F6501FF9F6E06479173512E00734A06072A864886FC6B01600C060A2A864886FC6B02020101630906072A864886FC6B03640B06092A864886FC6B040215650B06092B8510864864020103660C060A2B060104012A026E01028408A0000000030000006F6F8408A000000003000000A5599F6501FF9F6E06479173512E00734A06072A864886FC6B01600C060A2A864886FC6B02020101630906072A864886FC6B03640B06092A864886FC6B040215650B06092B8510864864020103660C060A2B060104012A026E01028408A000000003000000",
                                                  0));

        tlvExpectedListDepth1.add(new TLVObject("01", "01", "01"));
        tlvExpectedList.add(new TLVObject("21", "03", tlvExpectedListDepth1));
        assertEquals(tlvExpectedList, TLVParserWithArrayList.parse("2103010101", 0));

        tlvExpectedList.clear();
        tlvExpectedListDepth1.clear();

        tlvExpectedList.add(new TLVObject("01", "01", "03"));
        tlvExpectedList.add(new TLVObject("01", "01", "02"));
        tlvExpectedList.add(new TLVObject("01", "01", "02"));
        assertEquals(tlvExpectedList, TLVParserWithArrayList.parse("010103010102010102", 0));

        tlvExpectedList.clear();

        tlvExpectedList.add(new TLVObject("01", "00"));
        tlvExpectedList.add(new TLVObject("02", "00"));
        tlvExpectedList.add(new TLVObject("03", "00"));
        assertEquals(tlvExpectedList, TLVParserWithArrayList.parse("010002000300", 0));

        tlvExpectedList.clear();

        tlvExpectedList.add(new TLVObject("01", "00"));
        tlvExpectedList.add(new TLVObject("02", "00"));
        assertEquals(tlvExpectedList, TLVParserWithArrayList.parse("01000200", 0));

        tlvExpectedList.clear();

        tlvExpectedList.add(new TLVObject("1F01", "8104", "01020304"));
        assertEquals(tlvExpectedList, TLVParserWithArrayList.parse("1F01810401020304", 0));

        tlvExpectedList.clear();

        tlvExpectedList.add(new TLVObject("1F03", "03", "111111"));
        assertEquals(tlvExpectedList, TLVParserWithArrayList.parse("1F0303111111", 0));

        tlvExpectedList.clear();

        tlvExpectedList.add(new TLVObject("1f01", "01", "ff"));
        assertEquals(tlvExpectedList, TLVParserWithArrayList.parse("1f0101ff", 0));

        tlvExpectedList.clear();

        tlvExpectedList.add(new TLVObject("1F01", "00"));
        assertEquals(tlvExpectedList, TLVParserWithArrayList.parse("1F0100", 0));

        tlvExpectedList.clear();

        tlvExpectedList.add(new TLVObject("AF", "00"));
        assertEquals(tlvExpectedList, TLVParserWithArrayList.parse("AF00", 0));

        tlvExpectedList.clear();

        tlvExpectedList.add(new TLVObject("01", "01", "01"));
        assertEquals(tlvExpectedList, TLVParserWithArrayList.parse("010101", 0));

    }
}
