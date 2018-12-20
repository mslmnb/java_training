package com.epam.bitstring;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BitString {
    private String bits;
    private static Integer zeroCount = 1;

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
        int startPosition = getStartPositionForOneMoving();
        int endPosition = getEndPositionForOneMoving(startPosition);
        BitString resultBitString;
        if (endPosition == 0) {
            resultBitString = this.moveZeroToRight(startPosition);
        } else {
            resultBitString = new BitString(reverse(startPosition, endPosition)).moveOneToLeft();
        }
        return resultBitString;
    }

    private BitString moveZeroToRight(int startPosition) {
        int endPosition = getEndPositionForZeroMoving(startPosition);
        BitString resultBitString;
        if (endPosition == 0) {
            resultBitString = this;
            BitString.zeroCount = 1;
        } else {
            resultBitString = new BitString(reverse(startPosition, endPosition)).moveZeroToRight(startPosition + zeroCount + 1);
        }
        return resultBitString;

    }

    private String reverse(int StartPosition, int EndPosition) {
        String sourceSubString = bits.substring(StartPosition, EndPosition);
        String reversedSubString = new StringBuilder(sourceSubString).reverse().toString();
        return bits.replaceFirst(sourceSubString, reversedSubString);
    }

    private int getEndPositionForZeroMoving(int startPosition) {
        int result = 0;
        while (BitString.zeroCount < bits.length()) {
            String regex = "10{" + BitString.zeroCount + "}1";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(bits);
            while (matcher.find()) {
                result = matcher.end();
                if (result > startPosition + 1) {
                    break;
                }
            }
            if (result > startPosition + 1) {
                break;
            } else {
                BitString.zeroCount++;
            }
        }
        return result;
    }

    private int getStartPositionForOneMoving() {
        int result = 0;
        while (result < length() && bits.charAt(result) == '0') {
            result++;
        }
        while (result < length() && bits.charAt(result) == '1') {
            result++;
        }
        result--;
        return result;
    }

    private int getEndPositionForOneMoving(int fromPosition) {
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
}

