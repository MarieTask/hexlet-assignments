package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;
// BEGIN
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Map;
// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    public void testSet() {
        String path = "src/test/resources/file";
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key3", "value3"));
        storage.set("key", "value");
        assertThat(storage.get("key", "default").equals("value"));
        storage.set("key", "value2");
        assertThat(storage.get("key", "default").equals("value2"));
    }
    @Test
    public void testUnset() {
        String path = "src/test/resources/file";
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key3", "value3"));
        storage.unset("key3");
        assertThat(storage.get("key3", "default").equals("default"));
    }
    @Test
    public void testGet() {
        String path = "src/test/resources/file";
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key3", "value3"));
        storage.get("key2", "default");
        assertThat(storage.get("key2", "default").equals("default"));
        assertThat(storage.get("key3", "default").equals("value3"));
    }
    @Test
    public void testToMap() {
        String path = "src/test/resources/file";
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key3", "value3"));
        assertThat(storage.toMap().equals(Map.of("key3", "value3")));
    }
    // END
}
