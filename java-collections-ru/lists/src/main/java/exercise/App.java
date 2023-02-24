package exercise;

import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String symbols, String word) {
        char[] symbolsArray = symbols.toLowerCase().toCharArray();
        char[] wordArray = word.toLowerCase().toCharArray();
        List<String> list = new ArrayList<>(0);
        if (symbolsArray.length < wordArray.length) {
            return false;
        }
        for (var i = 0; i < symbolsArray.length; i++) {
            list.add(String.valueOf(symbolsArray[i]));
        }
        for (var j = 0; j < wordArray; j++) {
            if (!list.contains((String.valueOf(word[k])))) {
                return false;
            } else {
                list.remove(String.valueOf(word[k]));
            }
        }
        return true;
    }
}
//END
