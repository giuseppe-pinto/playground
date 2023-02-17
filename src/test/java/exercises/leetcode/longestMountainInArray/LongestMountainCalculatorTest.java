package exercises.leetcode.longestMountainInArray;

import exercises.leetcode.longestMountainInArray.exception.NotEnoughDataException;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


class LongestMountainCalculatorTest {
  private final LongestMountainCalculator calculator = new LongestMountainCalculator();

  @Test
  void notEnoughData() {

    int[] mountains = {1,2};

    assertThatExceptionOfType(NotEnoughDataException.class)
            .isThrownBy(() -> calculator.exec(mountains));
  }

  @Test
  void mountainOf5Element() {
    int[] mountains = {2,1,4,7,3,2,5};
    int actualLength = calculator.exec(mountains);
    assertThat(actualLength).isEqualTo(5);
  }


  @Test
  void multipleMountains() {
    int[] mountains = {2,3,6,8,1,4,5,6,5,1,2,1};
    int actualLength = calculator.exec(mountains);
    assertThat(actualLength).isEqualTo(6);
  }

  @Test
  void longestMountainsAsLast() {
    int[] mountains = {2,3,6,8,1,4,5,6,5,1,2,3,4,5,6,5,4,3,2};
    int actualLength = calculator.exec(mountains);
    assertThat(actualLength).isEqualTo(10);
  }

  @Test
  void mountainToTheBeginning() {
    int[] mountains = {1,2,3,4,5,6,5,4,3,2,2,3,6,8,1,4,5,6,5};
    int actualLength = calculator.exec(mountains);
    assertThat(actualLength).isEqualTo(10);
  }

  @Test
  void noMountains() {
    int[] mountains = {2,2,2};
    int actualLength = calculator.exec(mountains);
    assertThat(actualLength).isEqualTo(0);
  }

  @Test
  void noMountainsWithACopy() {
    int[] mountains = {2,2,3,3};
    int actualLength = calculator.exec(mountains);
    assertThat(actualLength).isEqualTo(0);
  }



}