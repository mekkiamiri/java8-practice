import com.java8.training.streams.StreamOperations;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StreamOperationsTest {

    private StreamOperations streamOperations = new StreamOperations();

    @Test
    public void should_make_pairs() {
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4,5);

        List<int[]> result = streamOperations.makePairs(list1, list2);

        Assertions.assertThat(result).contains(
                new int[]{1,4}, new int[]{1,5},
                new int[]{2,4}, new int[]{2,5},
                new int[]{3,4}, new int[]{3,5});

    }

    @Test
    public void should_generate_fibonacci_numbers() {
        Assertions.assertThat(streamOperations.generateNFibonnacciNumber(8))
                .isEqualTo("[0, 1],[1, 1],[1, 2],[2, 3],[3, 5],[5, 8],[8, 13],[13, 21]");
    }
}
