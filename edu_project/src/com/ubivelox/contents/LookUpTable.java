package com.ubivelox.contents;

import java.util.HashMap;

public class LookUpTable {
	
	private static int length = 0;

	final String[] HEX_ARRAY = new String[] {
			"00",			"01",			"02",			"03",			"04",			"05",			"06",			"07",
			"08",			"09",			"0A",			"0B",			"0C",			"0D",			"0E",			"0F",
			"10",			"11",			"12",			"13",			"14",			"15",			"16",			"17",
			"18",			"19",			"1A",			"1B",			"1C",			"1D",			"1E",			"1F",
			"20",			"21",			"22",			"23",			"24",			"25",			"26",			"27",
			"28",			"29",			"2A",			"2B",			"2C",			"2D",			"2E",			"2F",
			"30",			"31",			"32",			"33",			"34",			"35",			"36",			"37",
			"38",			"39",			"3A",			"3B",			"3C",			"3D",			"3E",			"3F",
			"40",			"41",			"42",			"43",			"44",			"45",			"46",			"47",
			"48",			"49",			"4A",			"4B",			"4C",			"4D",			"4E",			"4F",
			"50",			"51",			"52",			"53",			"54",			"55",			"56",			"57",
			"58",			"59",			"5A",			"5B",			"5C",			"5D",			"5E",			"5F",
			"60",			"61",			"62",			"63",			"64",			"65",			"66",			"67",
			"68",			"69",			"6A",			"6B",			"6C",			"6D",			"6E",			"6F",
			"70",			"71",			"72",			"73",			"74",			"75",			"76",			"77",
			"78",			"79",			"7A",			"7B",			"7C",			"7D",			"7E",			"7F"
	};
	 
	HashMap<Integer, String> map = new HashMap<Integer, String>();
	
	public LookUpTable (){
		length();
		
		settingMap();
	}
	
	private void settingMap() {
		map.put(0, "00");
		map.put(1, "01");
		map.put(2, "02");
		map.put(3, "03");
		map.put(4, "04");
		map.put(5, "05");
		map.put(6, "06");
		map.put(7, "07");
		map.put(8, "08");
		map.put(9, "09");
		map.put(10, "0A");
		map.put(11, "0B");
		map.put(12, "0C");
		map.put(13, "0D");
		map.put(14, "0E");
		map.put(15, "0F");
		map.put(16, "10");
		map.put(17, "11");
		map.put(18, "12");
		map.put(19, "13");
		map.put(20, "14");
		map.put(21, "15");
		map.put(22, "16");
		map.put(23, "17");
		map.put(24, "18");
		map.put(25, "19");
		map.put(26, "1A");
		map.put(27, "1B");
		map.put(28, "1C");
		map.put(29, "1D");
		map.put(30, "1E");
		map.put(31, "1F");
		map.put(32, "20");
		map.put(33, "21");
		map.put(34, "22");
		map.put(35, "23");
		map.put(36, "24");
		map.put(37, "25");
		map.put(38, "26");
		map.put(39, "27");
		map.put(40, "28");
		map.put(41, "29");
		map.put(42, "2A");
		map.put(43, "2B");
		map.put(44, "2C");
		map.put(45, "2D");
		map.put(46, "2E");
		map.put(47, "2F");
		map.put(48, "30");
		map.put(49, "31");
		map.put(50, "32");
		map.put(51, "33");
		map.put(52, "34");
		map.put(53, "35");
		map.put(54, "36");
		map.put(55, "37");
		map.put(56, "38");
		map.put(57, "39");
		map.put(58, "3A");
		map.put(59, "3B");
		map.put(60, "3C");
		map.put(61, "3D");
		map.put(62, "3E");
		map.put(63, "3F");
		map.put(64, "40");
		map.put(65, "41");
		map.put(66, "42");
		map.put(67, "43");
		map.put(68, "44");
		map.put(69, "45");
		map.put(70, "46");
		map.put(71, "47");
		map.put(72, "48");
		map.put(73, "49");
		map.put(74, "4A");
		map.put(75, "4B");
		map.put(76, "4C");
		map.put(77, "4D");
		map.put(78, "4E");
		map.put(79, "4F");
		map.put(80, "50");
		map.put(81, "51");
		map.put(82, "52");
		map.put(83, "53");
		map.put(84, "54");
		map.put(85, "55");
		map.put(86, "56");
		map.put(87, "57");
		map.put(88, "58");
		map.put(89, "59");
		map.put(90, "5A");
		map.put(91, "5B");
		map.put(92, "5C");
		map.put(93, "5D");
		map.put(94, "5E");
		map.put(95, "5F");
		map.put(96, "60");
		map.put(97, "61");
		map.put(98, "62");
		map.put(99, "63");
		map.put(100, "64");
		map.put(101, "65");
		map.put(102, "66");
		map.put(103, "67");
		map.put(104, "68");
		map.put(105, "69");
		map.put(106, "6A");
		map.put(107, "6B");
		map.put(108, "6C");
		map.put(109, "6D");
		map.put(110, "6E");
		map.put(111, "6F");
		map.put(112, "70");
		map.put(113, "71");
		map.put(114, "72");
		map.put(115, "73");
		map.put(116, "74");
		map.put(117, "75");
		map.put(118, "76");
		map.put(119, "77");
		map.put(120, "78");
		map.put(121, "79");
		map.put(122, "7A");
		map.put(123, "7B");
		map.put(124, "7C");
		map.put(125, "7D");
		map.put(126, "7E");
		map.put(127, "7F");
	}

	int length() {
		this.length = HEX_ARRAY.length;
		return length;
	}

	public String mapping(int dec) {
		return HEX_ARRAY[dec];
	}
	

	public String hashmapping(int dec) {
		return map.get(dec);
	}
}
