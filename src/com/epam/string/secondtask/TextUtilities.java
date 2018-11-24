package com.epam.string.secondtask;

import com.epam.string.secondtask.model.TextComponent;

import java.util.Arrays;
import java.util.List;

public class TextUtilities {
    final static List<Character> VOWELS = Arrays.asList('a', 'e', 'i', 'j', 'o', 'u', 'y', 'A', 'E', 'I', 'J', 'O', 'U', 'Y');
    final static int SMALL_A_CODE = 97;
    final static int SMALL_Z_CODE = 122;
    final static int CAPITAL_A_CODE = 65;
    final static int CAPITAL_Z_CODE = 90;

    public static char getFirstLetter(TextComponent component) {
        return component.getSourceText().toCharArray()[0];
    }

    public static boolean isVowel(char ch) {
        return VOWELS.contains(ch);
    }

    public static char getFirstConcordant(TextComponent component) {
        char resultChar = ' ';
        char[] symbols = component.getSourceText().toCharArray();
        for (char symbol: symbols) {
            if (isConcordant(symbol)) {
                resultChar = symbol;
                break;
            }
        }
        return resultChar;
    }

    public static boolean isConcordant(char ch) {
        int code = (int)ch;
        return ((code >= SMALL_A_CODE && code <= SMALL_Z_CODE)
                ||(code >= CAPITAL_A_CODE && code <= CAPITAL_Z_CODE))
                && !isVowel(ch);
    }

}
