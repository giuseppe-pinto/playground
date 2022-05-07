import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

  @Test
  void name() {

    String actual = Result.timeConversion("07:50:40PM");

    assertEquals("19:50:40", actual);


  }
}