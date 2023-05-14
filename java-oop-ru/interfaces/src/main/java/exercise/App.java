package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int n) {
        List<String> result = apartments.stream()
                .limit(n)
                .sorted(Comparator.comparing(x -> x.getArea()))
                .map(x -> x.toString())
                .collect(Collectors.toList());
        return result;
    }
}
// END
