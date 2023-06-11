package exercise;

/*
 import java.util.HashMap;
 import java.util.Map;
*/

import java.util.Map.Entry;
// import java.util.Set;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage database) {
        for (Entry<String, String> reverse : database.toMap().entrySet()) {
            database.set(reverse.getValue(), reverse.getKey());
        }
    }
}
// END
