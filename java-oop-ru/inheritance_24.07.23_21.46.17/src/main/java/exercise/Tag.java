package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {

    // Общий вид тегов следующий:
    // <тег атрибут1="значение1" атрибут2="значение2">
    // <тег атрибут1="значение1" атрибут2="значение2">...</тег>
    String name;
    Map<String, String> attributes;

    public Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public String getName() {

        return this.name;
    }

    public Map<String, String> getAttributes() {

        return this.attributes;
    }
}

// END
