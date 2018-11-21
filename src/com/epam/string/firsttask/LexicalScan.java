package com.epam.string.firsttask;

import java.util.*;

public class LexicalScan {

    public static List<CharacterCounter> getCharacterCounterList (String sourceText) {
        char[] sourceChars = sourceText.toLowerCase().toCharArray();
        Map<Character, CharacterCounter> counterMap = new HashMap<>();
        for (char ch : sourceChars) {
            if (!counterMap.containsKey(ch)) {
                counterMap.put(ch, new CharacterCounter(ch, 0));
            }
            counterMap.get(ch).incrementCount();
        }
        List <CharacterCounter> resultList = new ArrayList<>(counterMap.values());
        Collections.sort(resultList, Collections.reverseOrder());
        return resultList;
    }

    public static List<CharacterCounter> getHeadCharacterCounterList(String sourceText, int toIndex) {
        return getCharacterCounterList(sourceText).subList(0, toIndex);
    }

}
