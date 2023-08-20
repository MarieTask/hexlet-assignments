package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
class Validator {

    public static List<String> validate(Object obj) throws IllegalAccessException {

        List<String> notValidFields = new ArrayList<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            if (notNull != null) {
                field.setAccessible(true);
                try {
                    if (field.get(obj) == null) {
                        notValidFields.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return notValidFields;
    }
    public static Map<String, List<String>> advancedValidate(Object obj) throws IllegalAccessException {
        Map<String, List<String>> result = new HashMap<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            MinLength minLength = field.getAnnotation(MinLength.class);
            field.setAccessible(true);
            if (notNull != null && field.get(obj) == null) {
                result.put(field.getName(), List.of("can not be null"));
            } else if (minLength != null) {
                String value = (String) field.get(obj);
                if (value.length() < minLength.minLength()) {
                    result.put(field.getName(), List.of("length less than 4"));
                }
            }
        }
        return result;
    }
}
// END
