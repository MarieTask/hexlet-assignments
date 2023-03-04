package exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Collections;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> wordsCount = new HashMap<>();
        if (sentence.equals("")) {
            return wordsCount;
        }
        String[] splittedSentence = sentence.split(" ");
        List<String> value = new ArrayList<>();
        Collections.addAll(value, splittedSentence);

        for (var i = 0; i < value.size(); i++) {
            Integer countOfWords = Collections.frequency(value, value.get(i));
            wordsCount.put(value.get(i), countOfWords);
        }
        return wordsCount;
    }
    public static String toString(Map<String, Integer> wordsCount) {
        if (wordsCount.isEmpty()) {
            return "{}";
        }
        var result = new StringBuilder("{");
        for (Map.Entry<String, Integer> words: wordsCount.entrySet()) {
            result.append("\n  ");
            result.append(words.getKey());
            result.append(": ");
            result.append(words.getValue());
        }
        result.append("\n}");
        return result.toString();
    }
}
//END
