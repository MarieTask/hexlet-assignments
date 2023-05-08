package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String getForwardedVariables(String content) {
        String[] strings = content.split("\n");
        return Arrays.stream(strings)
                .filter(str -> str.startsWith("environment"))
                .map(str -> str.replaceAll("environment=\"", ""))
                .map(str -> str.split(","))
                .flatMap(str -> Stream.of(str))
                .filter(str -> str.startsWith("X_FORWARDED_"))
                .map(str -> str.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
