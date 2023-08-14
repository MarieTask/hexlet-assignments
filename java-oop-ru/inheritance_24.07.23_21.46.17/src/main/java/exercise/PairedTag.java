package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {

    // класс PairedTag, который наследуется от класса Tag и описывает парный html тег. Конструктор класса
    // принимает четыре аргумента:
    // Имя тега в виде строки
    // Атрибуты тега, которые представлены словарём Map со строковыми ключами и значениями.
    // Тело тега, строка
    // Список List детей. В этом задании детьми могут быть только одиночные теги.

    String body;
    List<Tag> children;

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        super(name, attributes);
        this.body = body;
        this.children = children;
    }

    // реализуйте публичный метод toString(), который возвращает текстовое представление тега в виде строки.
    // "<p id="abc">Text paragraph</p>"
    // <div class="y-5"><br id="s"><hr class="a-5"></div>"

    public String toString() {
        StringBuilder sb = new StringBuilder("<" + this.name);
        for (Map.Entry<String, String> key: attributes.entrySet()) {
            sb.append(" ")
                    .append(key.getKey() + "=\"")
                    .append(key.getValue() + "\"");
        }
        sb.append(">")
        .append(this.body);

        for (Tag tag: children) {
            sb.append(tag);
        }
        sb.append("</" + this.name + ">");
        return sb.toString();
    }

}

// END
