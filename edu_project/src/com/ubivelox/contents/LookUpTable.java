package com.ubivelox.contents;

import java.util.HashMap;

public class LookUpTable
{

    private static int       length    = 0;

    final String[]           HEX_ARRAY = new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "0A", "0B", "0C", "0D", "0E", "0F", "10", "11", "12", "13", "14", "15", "16", "17",
                                                        "18", "19", "1A", "1B", "1C", "1D", "1E", "1F", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "2A", "2B", "2C", "2D", "2E", "2F",
                                                        "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "3A", "3B", "3C", "3D", "3E", "3F", "40", "41", "42", "43", "44", "45", "46", "47",
                                                        "48", "49", "4A", "4B", "4C", "4D", "4E", "4F", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "5A", "5B", "5C", "5D", "5E", "5F",
                                                        "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "6A", "6B", "6C", "6D", "6E", "6F", "70", "71", "72", "73", "74", "75", "76", "77",
                                                        "78", "79", "7A", "7B", "7C", "7D", "7E", "7F" };

    HashMap<Integer, String> map       = new HashMap<>();





    public LookUpTable()
    {
        length();
        settingMap();
    }





    private void settingMap()
    {
        this.map.put(0, "00");
        this.map.put(1, "01");
        this.map.put(2, "02");
        this.map.put(3, "03");
        this.map.put(4, "04");
        this.map.put(5, "05");
        this.map.put(6, "06");
        this.map.put(7, "07");
        this.map.put(8, "08");
        this.map.put(9, "09");
        this.map.put(10, "0A");
        this.map.put(11, "0B");
        this.map.put(12, "0C");
        this.map.put(13, "0D");
        this.map.put(14, "0E");
        this.map.put(15, "0F");
        this.map.put(16, "10");
        this.map.put(17, "11");
        this.map.put(18, "12");
        this.map.put(19, "13");
        this.map.put(20, "14");
        this.map.put(21, "15");
        this.map.put(22, "16");
        this.map.put(23, "17");
        this.map.put(24, "18");
        this.map.put(25, "19");
        this.map.put(26, "1A");
        this.map.put(27, "1B");
        this.map.put(28, "1C");
        this.map.put(29, "1D");
        this.map.put(30, "1E");
        this.map.put(31, "1F");
        this.map.put(32, "20");
        this.map.put(33, "21");
        this.map.put(34, "22");
        this.map.put(35, "23");
        this.map.put(36, "24");
        this.map.put(37, "25");
        this.map.put(38, "26");
        this.map.put(39, "27");
        this.map.put(40, "28");
        this.map.put(41, "29");
        this.map.put(42, "2A");
        this.map.put(43, "2B");
        this.map.put(44, "2C");
        this.map.put(45, "2D");
        this.map.put(46, "2E");
        this.map.put(47, "2F");
        this.map.put(48, "30");
        this.map.put(49, "31");
        this.map.put(50, "32");
        this.map.put(51, "33");
        this.map.put(52, "34");
        this.map.put(53, "35");
        this.map.put(54, "36");
        this.map.put(55, "37");
        this.map.put(56, "38");
        this.map.put(57, "39");
        this.map.put(58, "3A");
        this.map.put(59, "3B");
        this.map.put(60, "3C");
        this.map.put(61, "3D");
        this.map.put(62, "3E");
        this.map.put(63, "3F");
        this.map.put(64, "40");
        this.map.put(65, "41");
        this.map.put(66, "42");
        this.map.put(67, "43");
        this.map.put(68, "44");
        this.map.put(69, "45");
        this.map.put(70, "46");
        this.map.put(71, "47");
        this.map.put(72, "48");
        this.map.put(73, "49");
        this.map.put(74, "4A");
        this.map.put(75, "4B");
        this.map.put(76, "4C");
        this.map.put(77, "4D");
        this.map.put(78, "4E");
        this.map.put(79, "4F");
        this.map.put(80, "50");
        this.map.put(81, "51");
        this.map.put(82, "52");
        this.map.put(83, "53");
        this.map.put(84, "54");
        this.map.put(85, "55");
        this.map.put(86, "56");
        this.map.put(87, "57");
        this.map.put(88, "58");
        this.map.put(89, "59");
        this.map.put(90, "5A");
        this.map.put(91, "5B");
        this.map.put(92, "5C");
        this.map.put(93, "5D");
        this.map.put(94, "5E");
        this.map.put(95, "5F");
        this.map.put(96, "60");
        this.map.put(97, "61");
        this.map.put(98, "62");
        this.map.put(99, "63");
        this.map.put(100, "64");
        this.map.put(101, "65");
        this.map.put(102, "66");
        this.map.put(103, "67");
        this.map.put(104, "68");
        this.map.put(105, "69");
        this.map.put(106, "6A");
        this.map.put(107, "6B");
        this.map.put(108, "6C");
        this.map.put(109, "6D");
        this.map.put(110, "6E");
        this.map.put(111, "6F");
        this.map.put(112, "70");
        this.map.put(113, "71");
        this.map.put(114, "72");
        this.map.put(115, "73");
        this.map.put(116, "74");
        this.map.put(117, "75");
        this.map.put(118, "76");
        this.map.put(119, "77");
        this.map.put(120, "78");
        this.map.put(121, "79");
        this.map.put(122, "7A");
        this.map.put(123, "7B");
        this.map.put(124, "7C");
        this.map.put(125, "7D");
        this.map.put(126, "7E");
        this.map.put(127, "7F");
    }





    int length()
    {
        this.length = this.HEX_ARRAY.length;
        return length;
    }





    public String mapping(final int dec)
    {
        return this.HEX_ARRAY[dec];
    }





    public String hashmapping(final int dec)
    {
        return this.map.get(dec);
    }
}
