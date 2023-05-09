package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        LinkedHashMap<String, String> resultData = new LinkedHashMap<>();
        Set<String> allKeys = new TreeSet<>(data1.keySet());
        allKeys.addAll(data2.keySet());

        for(String key: allKeys) {
            if (!data1.containsKey(key)) {
                resultData.put(key, "added");
            } else if (!data2.containsKey(key)) {
                resultData.put(key, "deleted");
            } else if (!data1.get(key).equals(data2.get(key))) {
                resultData.put(key, "changed");
            } else {
                resultData.put(key, "unchanged");
            }
        }
        return resultData;
    }
}
//END
