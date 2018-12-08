package com.epam._old.encoder;

/**
 * Chiffre Vigenere
 */
public class Encoder {
    final static int CHAR_A_CODE = 97;
    final static int CHAR_Z_CODE = 122;
    final int ALFABET_LETTERS_COUNT = 26;

    private final char[] secretWord;

    public Encoder(String secretWord) {
        this.secretWord = secretWord.toLowerCase().toCharArray();
    }

    int getNumberFor(char ch) {
        return (int) ch - CHAR_A_CODE;
    }

    char sumOfChars(char a, char b) {
        return (char) ((getNumberFor(a) + getNumberFor(b)) % ALFABET_LETTERS_COUNT + CHAR_A_CODE);
    }

    private char differenceOfChars(char a, char b) {
        int numberForA = getNumberFor(a);
        int numberForB = getNumberFor(b);
        if (numberForA < numberForB) {
            numberForA += ALFABET_LETTERS_COUNT;
        }
        return (char) (numberForA - numberForB + CHAR_A_CODE);
    }

    public String encodeString(String sourceString) {
        String space = " ";
        String blank = "";
        char[] source = sourceString.replaceAll(space, blank).toLowerCase().toCharArray();
        char[] target = new char[source.length];
        int j = 0;

        for (int i = 0; i < target.length; i++) {
            checkRange(source[i]);
            target[i] = sumOfChars(source[i], secretWord[j]);
            j = (j < secretWord.length - 1) ? j + 1 : 0;
        }
        return new String(target);
    }

    public String decodeString(String sourceString) {
        char[] source = sourceString.toCharArray();
        char[] target = new char[source.length];
        int j = 0;

        for (int i = 0; i < target.length; i++) {
            checkRange(source[i]);
            target[i] = differenceOfChars(source[i], secretWord[j]);
            j = (j < secretWord.length - 1) ? j + 1 : 0;
        }
        return new String(target);
    }

    public static void checkRange(char ch) {
        int charCode = (int) ch;
        if (charCode > CHAR_Z_CODE || charCode < CHAR_A_CODE){
            throw new IllegalArgumentException("String must contain only latin characters");
        }
    }
}
