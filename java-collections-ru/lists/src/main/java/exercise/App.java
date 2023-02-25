package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String symbols, String word) {
        List<String> symbolsList = new ArrayList<>(Arrays.asList(symbols.toLowerCase().split("")));
        List<String> wordList = new ArrayList<>(Arrays.asList(word.toLowerCase().split("")));
        if (symbolsList.size() < wordList.size()) {
            return false;
        }
        var j = 0;
        for (var i = 0; i < symbolsList.size(); i++) {
            if (!symbolsList.contains(wordList.get(j))) {
                return false;
            } else {
                symbolsList.remove(wordList.get(j));
                j++;
            }
        }
        return true;
    }
}
//END
