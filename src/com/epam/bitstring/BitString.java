package com.epam.bitstring;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BitString {
    String bits;

    public BitString(String bits) {
        this.bits = bits.trim();
    }

    public String getBits() {
        return bits;
    }

    public int length() {
        return bits.length();
    }

    public BitString moveOneToLeft() {
        int startPosition = getStartPositionForReverse();
        int endPosition = getEndPositionForReverse(startPosition);
        BitString resultBitString;
        if (endPosition == 0) {
            resultBitString = this;
        } else {
            resultBitString = new BitString(reverse(startPosition, endPosition)).moveOneToLeft();
        }
        return resultBitString;
    }

    private String reverse(int StartPosition, int EndPosition) {
        String sourceSubString = bits.substring(StartPosition, EndPosition);
        String reversedSubString = new StringBuilder(sourceSubString).reverse().toString();
        return bits.replaceFirst(sourceSubString, reversedSubString);
    }

    private int getStartPositionForReverse() {
        int result = 0;
        while (result < length() && bits.charAt(result)=='0' ) {
            result++;
        }
        while (result < length() && bits.charAt(result)=='1') {
            result++;
        }
        result--;
        return result;
    }

    private int getEndPositionForReverse(int fromPosition) {
        int result = 0;
        Pattern pattern = Pattern.compile("1{2,}");
        Matcher matcher = pattern.matcher(bits.substring(fromPosition));
        if (matcher.find()) {
            result = matcher.end() + fromPosition;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BitString)) return false;

        BitString bitString = (BitString) o;

        return getBits() != null ? moveOneToLeft().toString().equals(bitString.moveOneToLeft().toString())
                                 : bitString.getBits() == null;
    }

    @Override
    public int hashCode() {
        return getBits() != null ? moveOneToLeft().toString().hashCode() : 0;
    }

    @Override
    public String toString() {
        return bits;
    }

    public static void main(String[] args) {
        BitString bitString1 = new BitString("00100111011110101100");
        BitString bitString2 = new BitString("00110011011101101100");
        System.out.println("Результат после смещения единиц влево:");
        System.out.println(bitString1.moveOneToLeft());
        System.out.println(bitString2.moveOneToLeft());
        System.out.println("Сравнение c помощью equals(): " + bitString1.equals(bitString2));
        System.out.println("Результат hashCode():");
        System.out.println(bitString1.hashCode());
        System.out.println(bitString2.hashCode());
    }
}

/*
Результат после смещения единиц влево:
00111111101010010100
00111111101010010100
Сравнение c помощью equals(): true
Результат hashCode():
1709765375
1709765375

 */
