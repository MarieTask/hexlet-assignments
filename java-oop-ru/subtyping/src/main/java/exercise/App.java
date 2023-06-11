package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage database) {
        database.toMap().entrySet().stream()
                .forEach(reverse -> database.set(reverse.getValue(), reverse.getKey()));
    }
}
// END
