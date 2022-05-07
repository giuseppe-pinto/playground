import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

class Result {

  /*
   * Complete the 'plusMinus' function below.
   *
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static void plusMinus(List<Integer> arr) {

    BigDecimal size = new BigDecimal(arr.size());

    BigDecimal positiveNumbersCounter = BigDecimal.ZERO;
    BigDecimal negativeNumbersCounter = BigDecimal.ZERO;
    BigDecimal zeroNumbersCounter = BigDecimal.ZERO;

    for (Integer element : arr) {
      if(element>0){
        positiveNumbersCounter = positiveNumbersCounter.add(BigDecimal.ONE);
      } else if(element<0){
        negativeNumbersCounter = negativeNumbersCounter.add(BigDecimal.ONE);
      } else {
        zeroNumbersCounter = zeroNumbersCounter.add(BigDecimal.ONE);
      }
    }

    BigDecimal positiveProportion = positiveNumbersCounter.divide(size, 6, RoundingMode.HALF_UP);
    BigDecimal negativeProportion = negativeNumbersCounter.divide(size, 6, RoundingMode.HALF_UP);
    BigDecimal zeroProportion = zeroNumbersCounter.divide(size, 6, RoundingMode.HALF_UP);

    System.out.println(positiveProportion);
    System.out.println(negativeProportion);
    System.out.println(zeroProportion);

  }

}
