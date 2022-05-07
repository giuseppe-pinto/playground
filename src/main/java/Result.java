import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Result {

  public static String timeConversion(String s) {

    LocalTime localTime = LocalTime.parse(s,
            DateTimeFormatter.ofPattern("h:m:sa"));

    return localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
  }
}
