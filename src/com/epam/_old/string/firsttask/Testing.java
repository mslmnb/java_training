package com.epam._old.string.firsttask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 *    Find and print n-characters (and their quantity) which are found most often
 */
public class Testing {
    public static void main(String[] args) {
        int toIndex = 6;
        System.out.println(LexicalScan.getHeadCharacterCounterList(getTextFromFile("c:\\test\\text.txt"), toIndex));
    }

    public static String getTextFromFile(String fileName) {
        String sourceText = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String currentLine;
            while ((currentLine = reader.readLine())!=null) {
                sourceText += currentLine;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sourceText;
    }
}

/*
[[' ', 14], ['t', 10], ['e', 10], ['r', 7], ['h', 7], ['o', 6]]


        **** text.txt *****
        The research director
        had the department do a
        thorough job in testing
        the new product

*/