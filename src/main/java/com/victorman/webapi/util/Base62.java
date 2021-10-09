package com.victorman.webapi.util;

import java.util.Map;
import java.util.TreeMap;

public class Base62 {

    public static String encode(long number) {
        StringBuilder stringBuilder = new StringBuilder();
        while (number != 0) {
            stringBuilder.append(CHAR_BY_NUMBER[(int) (number % BASE)]);
            number /= BASE;
        }
        return stringBuilder.reverse().toString();
    }

    public static long decode(String string) {
        long result = 0;
        long multiplier = 1;
        for (int i = string.length() - 1; i >= 0; i--) {
            result += multiplier * NUMBER_BY_CHAR.get(string.charAt(i));
            multiplier *= BASE;
        }
        System.out.println("RESULT: " + result);
        return result;
    }

    private static final char[] CHAR_BY_NUMBER = {
            '0', '1', '2', '3', '4', '5', '6', // 0
            '7', '8', '9', 'A', 'B', 'C', 'D', // 1
            'E', 'F', 'G', 'H', 'I', 'J', 'K', // 2
            'L', 'M', 'N', 'O', 'P', 'Q', 'R', // 3
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', // 4
            'Z', 'a', 'b', 'c', 'd', 'e', 'f', // 5
            'g', 'h', 'i', 'j', 'k', 'l', 'm', // 6
            'n', 'o', 'p', 'q', 'r', 's', 't', // 7
            'u', 'v', 'w', 'x', 'y', 'z',      // 8
    };
    private static final Map<Character, Integer> NUMBER_BY_CHAR = new TreeMap<>();
    static {
        for (int i = 0; i < CHAR_BY_NUMBER.length; i++) {
            NUMBER_BY_CHAR.put(CHAR_BY_NUMBER[i], i);
        }
    }

    // Should be equals 62:
    private static final int BASE = CHAR_BY_NUMBER.length;

}
