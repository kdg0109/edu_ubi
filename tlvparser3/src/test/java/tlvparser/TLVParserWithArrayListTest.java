package tlvparser;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import com.ubivelox.gaia.GaiaException;

import exception.UbiveloxException;
import tlvparser.TLVParserWithArrayListTest.TLVObject;

public class TLVParserWithArrayListTest {

	public static class TLVObject {

		String tag;
		String length;
		String stringValue;
		ArrayList<TLVObject> value;
		
		
		public TLVObject() {
		}

		public TLVObject(String tag, String length, ArrayList<TLVObject> value) {
			super();
			this.tag = tag;
			this.length = length;
			this.value = value;
		}

		public TLVObject(String tag, String length, String value) {
			super();
			this.tag = tag;
			this.length = length;
			this.stringValue = value;
		}
		
		public TLVObject(String tag, String length, String stringValue, ArrayList<TLVObject> value) {
			super();
			this.tag = tag;
			this.length = length;
			this.stringValue = stringValue;
			this.value = value;
		}

		public String getStringValue() {
			return stringValue;
		}
		public void setStringValue(String stringValue) {
			this.stringValue = stringValue;
		}
		public String getTag() {
			return tag;
		}
		public void setTag(String tag) {
			this.tag = tag;
		}
		public String getLength() {
			return length;
		}
		public void setLength(String length) {
			this.length = length;
		}
		public ArrayList<TLVObject> getValue() {
			return value;
		}
		public void setValue(ArrayList<TLVObject> value) {
			this.value = value;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((length == null) ? 0 : length.hashCode());
			result = prime * result + ((stringValue == null) ? 0 : stringValue.hashCode());
			result = prime * result + ((tag == null) ? 0 : tag.hashCode());
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			TLVObject other = (TLVObject) obj;
			if (length == null) {
				if (other.length != null)
					return false;
			} else if (!length.equals(other.length))
				return false;
			if (stringValue == null) {
				if (other.stringValue != null)
					return false;
			} else if (!stringValue.equals(other.stringValue))
				return false;
			if (tag == null) {
				if (other.tag != null)
					return false;
			} else if (!tag.equals(other.tag))
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}
		
	}
	
	
	

	@Test
	public void test() throws UbiveloxException, GaiaException {
		ArrayList<TLVObject> tlvList = new ArrayList<TLVObject>();
		ArrayList<TLVObject> tlvList2 = new ArrayList<TLVObject>();
		ArrayList<TLVObject> tlvList3 = new ArrayList<TLVObject>();
		ArrayList<TLVObject> tlvList4 = new ArrayList<TLVObject>();
		ArrayList<TLVObject> tlvList5 = new ArrayList<TLVObject>();
		ArrayList<TLVObject> tlvList6 = new ArrayList<TLVObject>();
		ArrayList<TLVObject> tlvList7 = new ArrayList<TLVObject>();
		ArrayList<TLVObject> tlvList8 = new ArrayList<TLVObject>();
		ArrayList<TLVObject> tlvList9 = new ArrayList<TLVObject>();
		ArrayList<TLVObject> tlvList12 = new ArrayList<TLVObject>();
		ArrayList<TLVObject> tlvList13 = new ArrayList<TLVObject>();
		ArrayList<TLVObject> tlvList14 = new ArrayList<TLVObject>();
		ArrayList<TLVObject> tlvList15 = new ArrayList<TLVObject>();
		ArrayList<TLVObject> tlvList16 = new ArrayList<TLVObject>();
		ArrayList<TLVObject> tlvList17 = new ArrayList<TLVObject>();
		ArrayList<TLVObject> tlvList18 = new ArrayList<TLVObject>();
		ArrayList<TLVObject> tlvList19 = new ArrayList<TLVObject>();
		
		
		tlvList.add(new TLVObject("6F", "6F", tlvList2));
		tlvList2.add(new TLVObject("84","08", "A000000003000000"));
		tlvList2.add(new TLVObject("A5","59", tlvList3));
		tlvList3.add(new TLVObject("9F65","01", "FF"));
		tlvList3.add(new TLVObject("9F6E","06", "479173512E00"));
		tlvList3.add(new TLVObject("73","4A", tlvList4));
		tlvList4.add(new TLVObject("06","07", "2A864886FC6B01"));
		tlvList4.add(new TLVObject("60","0C", tlvList5));
		tlvList5.add(new TLVObject("06","0A", "2A864886FC6B02020101"));
		tlvList4.add(new TLVObject("63","09", tlvList6));
		tlvList6.add(new TLVObject("06", "07", "2A864886FC6B03"));
		tlvList4.add(new TLVObject("64","0B", tlvList7));
		tlvList7.add(new TLVObject("06","09","2A864886FC6B040215"));
		tlvList4.add(new TLVObject("65","0B", tlvList8));
		tlvList8.add(new TLVObject("06", "09", "2B8510864864020103"));
		tlvList4.add(new TLVObject("66","0C", tlvList9));
		tlvList9.add(new TLVObject("06","0A", "2B060104012A026E0102"));
		tlvList2.add(new TLVObject("84","08", "A000000003000000"));
		
		tlvList.add(new TLVObject("6F", "6F", tlvList12));
		tlvList12.add(new TLVObject("84","08", "A000000003000000"));
		tlvList12.add(new TLVObject("A5","59", tlvList13));
		tlvList13.add(new TLVObject("9F65","01", "FF"));
		tlvList13.add(new TLVObject("9F6E","06", "479173512E00"));
		tlvList13.add(new TLVObject("73","4A", tlvList14));
		tlvList14.add(new TLVObject("06","07", "2A864886FC6B01"));
		tlvList14.add(new TLVObject("60","0C", tlvList15));
		tlvList15.add(new TLVObject("06","0A", "2A864886FC6B02020101"));
		tlvList14.add(new TLVObject("63","09", tlvList16));
		tlvList16.add(new TLVObject("06", "07", "2A864886FC6B03"));
		tlvList14.add(new TLVObject("64","0B", tlvList17));
		tlvList17.add(new TLVObject("06","09","2A864886FC6B040215"));
		tlvList14.add(new TLVObject("65","0B", tlvList18));
		tlvList18.add(new TLVObject("06", "09", "2B8510864864020103"));
		tlvList14.add(new TLVObject("66","0C", tlvList19));
		tlvList19.add(new TLVObject("06","0A", "2B060104012A026E0102"));
		tlvList12.add(new TLVObject("84","08", "A000000003000000"));
		
		
//		tlvList.add(new TLVObject("21", "05", tlvList2));
//		tlvList2.add(new TLVObject("21", "03", tlvList3));
//		tlvList3.add(new TLVObject("01", "01","01"));
//		tlvList.add(new TLVObject("21", "05", tlvList4));
//		tlvList4.add(new TLVObject("21", "03", tlvList5));
//		tlvList5.add(new TLVObject("01", "01", "01"));
		
//		tlvList2.add(new TLVObject("84", "08", "A000000003000000"));
//		tlvList.add(new TLVObject("6F", "6F", tlvList2));
//		tlvList.add(new TLVObject("6F", "6F", tlvList2));
//		tlvList2.add(new TLVObject("84", "08", "A000000003000000",tlvList3));
//		tlvList3.add(new TLVObject("A5", "59", tlvList4));
//		tlvList4.add(new TLVObject("9F65", "01", "FF"));
		
//		tlvList.add(new TLVObject("6F", "6F", tlvList2));
//		tlvList2.add(new TLVObject("84", "08", "A000000003000000"));
//		tlvList2.add(new TLVObject("A5", "59", tlvList3));
//		tlvList3.add(new TLVObject("9F65", "01", "FF"));
//		tlvList3.add(new TLVObject("9F6E", "06", "479173512E00"));
//		tlvList3.add(new TLVObject("73", "4A", tlvList4));
//		tlvList4.add(new TLVObject("06", "07", "2A864886FC6B01"));
//		tlvList4.add(new TLVObject("60", "0C", tlvList5));
//		tlvList5.add(new TLVObject("06", "0A", "2A864886FC6B02020101"));
//		tlvList4.add(new TLVObject("63", "09", tlvList6));
//		tlvList6.add(new TLVObject("06", "09", "2A864886FC6B03"));
//		tlvList4.add(new TLVObject("64", "0B", tlvList8));
//		tlvList8.add(new TLVObject("06", "09", "2A864886FC6B040215"));
//		tlvList4.add(new TLVObject("65", "0B", tlvList9));
//		tlvList9.add(new TLVObject("65", "09", "2B8510864864020103"));
//		tlvList4.add(new TLVObject("66", "0C", tlvList10));
//		tlvList10.add(new TLVObject("06", "0A", "2B060104012A026E0102"));
//		tlvList2.add(new TLVObject("84", "08", "A000000003000000"));
//		tlvList2.add(new TLVObject("01", "01", "01"));
//		tlvList.add(new TLVObject("01", "01", "01"));
//		tlvList.add(new TLVObject("01", "02", "0101"));
//		tlvList.add(new TLVObject("1F01", "01", "01"));
//		tlvList.add(new TLVObject("21", "03", tlvList2));
		
		
		assertEquals(tlvList, TLVParserWithArrayList.parse("6F6F8408A000000003000000A5599F6501FF9F6E06479173512E00734A06072A864886FC6B01600C060A2A864886FC6B02020101630906072A864886FC6B03640B06092A864886FC6B040215650B06092B8510864864020103660C060A2B060104012A026E01028408A0000000030000006F6F8408A000000003000000A5599F6501FF9F6E06479173512E00734A06072A864886FC6B01600C060A2A864886FC6B02020101630906072A864886FC6B03640B06092A864886FC6B040215650B06092B8510864864020103660C060A2B060104012A026E01028408A000000003000000"));
//		assertEquals(tlvList, TLVParserWithArrayList.parse("2105210301010121052103010101", 0));
//		assertEquals(tlvList, TLVParserWithArrayList.parse("21052103010101", 0));
//		assertEquals(tlvList, TLVParserWithArrayList.parse("2103010101", 0));
//		assertEquals(tlvList, TLVParserWithArrayList.parse("01020101", 0));
//		assertEquals(tlvList, TLVParserWithArrayList.parse("010101", 0));
//		assertEquals(tlvList, TLVParserWithArrayList.parse("010101", 0));
//		assertEquals("01\t03\t010101", TLVParserWithArrayList.parse("0103010101", 0));
//		assertEquals("01\t01\t01", TLVParserWithArrayList.parse("010101", 0));

	}


}
