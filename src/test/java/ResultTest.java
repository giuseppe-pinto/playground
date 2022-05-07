import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

  @Test
  void name() {

    String actual = Result.timeConversion("07:05:45PM");

    assertEquals("19:05:45", actual);


  }
}