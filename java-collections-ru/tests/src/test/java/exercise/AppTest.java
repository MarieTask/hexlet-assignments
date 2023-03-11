package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> elements = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int count = 3;
        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(2);
        result.add(3);
        List<Integer> actual = App.take(elements, count);
        Assertions.assertThat(result)
                .isEqualTo(actual);
        // END
    }
}
