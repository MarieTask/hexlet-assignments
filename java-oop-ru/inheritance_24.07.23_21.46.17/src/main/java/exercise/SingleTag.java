package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    // класс SingleTag наследуется от класса Tag и описывает одиночный html тег.
    // Конструктор класса принимает два аргумента:
    // Имя тега в виде строки
    // Атрибуты тега, которые представлены словарём Map со строковыми ключами и значениями.

    public SingleTag(String name, Map<String, String> attributes) {

        super(name, attributes);
    }

    //В классе реализуйте публичный метод toString(), который возвращает текстовое представление тега в виде строки.
    // Tag img = new SingleTag("img", Map.of("class", "v-10", "id", "wop"));
    // img.toString(); // "<img class="v-10" id="wop">

    public String toString() {
        StringBuilder sb = new StringBuilder("<" + this.name);
            for (Map.Entry<String, String> key: attributes.entrySet()) {
                sb.append(" ")
                        .append(key.getKey() + "=\"")
                        .append(key.getValue() + "\"");
            }
            sb.append(">");
            return sb.toString();
        }
}
// END
