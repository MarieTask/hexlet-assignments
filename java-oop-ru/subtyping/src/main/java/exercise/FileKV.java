package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private String filepath;
    private Map<String, String> database;

    public FileKV(String filepath, Map<String, String> database) {
        this.filepath = filepath;
        this.database = new HashMap<>(database);
    }

    @Override
    public void set(String key, String value) {
        String fileContent = Utils.readFile(filepath);
        Map<String, String> data = Utils.unserialize(fileContent);
        data.put(key, value);
        Utils.writeFile(filepath, Utils.serialize(data));
    }

    @Override
    public void unset(String key) {
        String fileContent = Utils.readFile(filepath);
        Map<String, String> data = Utils.unserialize(fileContent);
        data.remove(key);
        Utils.writeFile(filepath, Utils.serialize(data));
    }

    @Override
    public String get(String key, String defaultValue) {
        String fileContent = Utils.readFile(filepath);
        Map<String, String> data = Utils.unserialize(fileContent);
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        String fileContent = Utils.readFile(filepath);
        Map<String, String> data = Utils.unserialize(fileContent);
        return new HashMap<>(data);
    }
}
// END
