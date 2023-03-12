package exercise;

import java.util.List;

// BEGIN
class App {
    public static boolean isFree (String freeDomens) {
        return freeDomens.contains("@gmail.com") || freeDomens.contains("@yandex.ru") || freeDomens.contains("@hotmail.com");
    }
    public static long getCountOfFreeEmails(List<String> emailsList) {
        long amount = emailsList.stream()
                .filter(email -> !email.isEmpty())
                .filter(email -> isFree(email))
                .count();
        return amount;
    }
}
// END
