import com.giuseppe.pinto.SeatManager;
import com.giuseppe.pinto.exception.NotAvailableSeatsException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AcceptanceTest {


  @Test
  void acceptance() {
    SeatManager seatManager = new SeatManager(5);

    int actual = seatManager.reserve();
    assertThat(actual).isEqualTo(1);

    actual = seatManager.reserve();
    assertThat(actual).isEqualTo(2);

    seatManager.unreserve(2);

    actual = seatManager.reserve();
    assertThat(actual).isEqualTo(2);

    actual = seatManager.reserve();
    assertThat(actual).isEqualTo(3);

    actual = seatManager.reserve();
    assertThat(actual).isEqualTo(4);

    actual = seatManager.reserve();
    assertThat(actual).isEqualTo(5);

    seatManager.unreserve(5);

    actual = seatManager.reserve();
    assertThat(actual).isEqualTo(5);

    seatManager.unreserve(2);

    actual = seatManager.reserve();
    assertThat(actual).isEqualTo(2);

    assertThrows(NotAvailableSeatsException.class, seatManager::reserve);

  }
}
