package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static exercise.App.take;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        Integer[] num = {1, 2, 3, 4, 5};
        List<Integer> numbers = new ArrayList<>(Arrays.asList(num));
        assertThat(take(numbers, 0)).isEqualTo(new ArrayList<>(0));
        assertThat(take(numbers, 1)).isEqualTo(new ArrayList<>(Arrays.asList(1)));
        assertThat(take(numbers, 4)).isEqualTo(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        assertThat(take(numbers, -1)).isEqualTo(new ArrayList<>(0));
        assertThat(take(numbers, 7)).isEqualTo(new ArrayList<>(numbers));
        // END
    }
}
