
import com.giuseppe.pinto.SeatManagerOptimized;
import com.giuseppe.pinto.exception.NotAvailableSeatsException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class SeatManagerTest2 {

  @Test
  void reserveTheFirstPlace() {
    SeatManagerOptimized seatManager = new SeatManagerOptimized(10);
    int actual = seatManager.reserve();
    assertThat(actual).isEqualTo(1);
  }

  @Test
  void reserveTwoPlaces() {
    SeatManagerOptimized seatManager = new SeatManagerOptimized(10);
    seatManager.reserve();
    int actual = seatManager.reserve();
    assertThat(actual).isEqualTo(2);
  }

  @Test
  void shouldGoInErrorWhenAskToReserveAnUnavailablePlace() {
    SeatManagerOptimized seatManager = new SeatManagerOptimized(0);
    assertThrows(NotAvailableSeatsException.class, seatManager::reserve);
  }

  @Test
  void unreserve() {
    SeatManagerOptimized seatManager = new SeatManagerOptimized(10);
    int reservedSeat = seatManager.reserve();
    seatManager.unreserve(reservedSeat);
    assertThat(seatManager.reserve()).isEqualTo(1);
  }

  @Test
  void name() {

    SeatManagerOptimized seatManager = new SeatManagerOptimized(3);

    System.out.println(seatManager.reserve());
    System.out.println(seatManager.reserve());

    seatManager.unreserve(1);
    seatManager.unreserve(2);

    System.out.println(seatManager.reserve());

    seatManager.unreserve(1);
    System.out.println(seatManager.reserve());
    seatManager.unreserve(1);

  }
}