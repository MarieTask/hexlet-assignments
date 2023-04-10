package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String symbols, String word) {
        List<String> symbolsList = new ArrayList<>(Arrays.asList(symbols.split("")));
        List<String> wordList = new ArrayList<>(Arrays.asList(word.split("")));
        if (symbolsList.size() < wordList.size()) {
            return false;
        }
        for (var i = 0; i < symbolsList.size(); i++) {
            if (symbolsList.contains(wordList.get(i))) {
                symbolsList.remove(wordList.get(i));
            }
            return false;
        }
        return true;
    }
}
//END
