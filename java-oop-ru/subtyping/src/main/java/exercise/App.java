package exercise;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage database) {
        database.toMap().entrySet().stream()
                .forEach(reverse -> {
                    database.unset(reverse.getKey()); database.set(reverse.getValue(), reverse.getKey())};);
    }
}
// END
