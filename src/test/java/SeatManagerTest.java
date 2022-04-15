import com.giuseppe.pinto.SeatManager;
import com.giuseppe.pinto.exception.NotAvailableSeatsException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class SeatManagerTest {

  @Test
  void reserveTheFirstPlace() {
    SeatManager seatManager = new SeatManager(10);
    int actual = seatManager.reserve();
    assertThat(actual).isEqualTo(1);
  }

  @Test
  void reserveTwoPlaces() {
    SeatManager seatManager = new SeatManager(10);
    seatManager.reserve();
    int actual = seatManager.reserve();
    assertThat(actual).isEqualTo(2);
  }

  @Test
  void shouldGoInErrorWhenAskToReserveAnUnavailablePlace() {
    SeatManager seatManager = new SeatManager(0);
    assertThrows(NotAvailableSeatsException.class, seatManager::reserve);
  }

  @Test
  void unreserve() {
    SeatManager seatManager = new SeatManager(10);
    int reservedSeat = seatManager.reserve();
    seatManager.unreserve(reservedSeat);
    assertThat(seatManager.reserve()).isEqualTo(1);
  }
}