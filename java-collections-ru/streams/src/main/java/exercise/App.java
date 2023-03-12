package exercise;

import java.util.List;

// BEGIN
class App {
    public static long getCountOfFreeEmails(List<String> emailsList) {
        List<String> freeDomens = List.of("gmail.com", "yandex.ru", "hotmail.com");
        long amount = emailsList.stream()
                .filter(email -> !email.isEmpty())
                .map(email -> email.split("@")[1])
                .filter(email -> freeDomens.contains(email))
                .count();
        return amount;
    }
}
// END
