package com.epam.string.secondtask;

import com.epam.string.secondtask.model.TextComponent;
import com.epam.string.secondtask.model.TextComponentType;
import com.epam.string.secondtask.model.TextComposite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.string.secondtask.TextUtilities.getFirstConcordant;
import static com.epam.string.secondtask.TextUtilities.getFirstLetter;
import static com.epam.string.secondtask.TextUtilities.isVowel;

/*
 *  To choose words on a vowel from the text.
 *  To sort them in alphabetical order on the first consonant of a word.
 */
public class Testing {

    public static void main(String[] args) {
        TextComposite textComposite = new TextComposite(TextComponentType.TEXT, getTextFromFile("c:\\test\\text.txt"));
        textComposite.parse();

        List<TextComponent> allWords = textComposite.getChildsByType(TextComponentType.WORD);
        List<TextComponent> wordsStartWithVowel = allWords.stream()
                                                          .filter(w -> isVowel(getFirstLetter(w))).collect(Collectors.toList());
        Collections.sort(wordsStartWithVowel, new Comparator<TextComponent>() {
            @Override
            public int compare(TextComponent component1, TextComponent component2) {
                return Character.compare(getFirstConcordant(component1), getFirstConcordant(component2));
            }
        });

        wordsStartWithVowel.stream().forEach(System.out::println);
    }


    public static String getTextFromFile(String fileName) {
        String sourceText = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String currentLine;
            while ((currentLine = reader.readLine())!=null) {
                sourceText += currentLine + "\r\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sourceText;
    }
}

/*
a
I
a
a
I
of
old
and
animals
and
and
on
enjoy
years
our
is
at

**** text.txt *****
My sister is 20 years old and she works at the City Zoo. She sees a lot of animals: bears, penguins, horses, squirrels, foxes and rabbits.
I want to see a snake and a giraffe there.
We will go there on the weekend. I will enjoy our family holiday!


 */
