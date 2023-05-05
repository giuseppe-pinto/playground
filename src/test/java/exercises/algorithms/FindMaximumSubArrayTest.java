package exercises.algorithms;

import org.junit.jupiter.api.Test;

import static exercises.algorithms.MaxSubArray.MaxSubArrayBuilder.aMaxSubArray;
import static org.assertj.core.api.Assertions.assertThat;

class FindMaximumSubArrayTest {

    @Test
    void findTheMaxSubArray() {
        Integer[] array = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        MaxSubArray actual = new FindMaximumSubArray().execute(array, 0, array.length-1);
        MaxSubArray expected = aMaxSubArray().withMaxLeft(7).withMaxRight(10).withSum(43).build();
        assertThat(actual).isEqualTo(expected);
    }

}