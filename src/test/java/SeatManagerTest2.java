
import com.giuseppe.pinto.SeatManagerWithSet;
import com.giuseppe.pinto.exception.NotAvailableSeatsException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class SeatManagerTest2 {

  @Test
  void reserveTheFirstPlace() {
    SeatManagerWithSet seatManager = new SeatManagerWithSet(10);
    int actual = seatManager.reserve();
    assertThat(actual).isEqualTo(1);
  }

  @Test
  void reserveTwoPlaces() {
    SeatManagerWithSet seatManager = new SeatManagerWithSet(10);
    seatManager.reserve();
    int actual = seatManager.reserve();
    assertThat(actual).isEqualTo(2);
  }

  @Test
  void shouldGoInErrorWhenAskToReserveAnUnavailablePlace() {
    SeatManagerWithSet seatManager = new SeatManagerWithSet(0);
    assertThrows(NotAvailableSeatsException.class, seatManager::reserve);
  }

  @Test
  void unreserve() {
    SeatManagerWithSet seatManager = new SeatManagerWithSet(10);
    int reservedSeat = seatManager.reserve();
    seatManager.unreserve(reservedSeat);
    assertThat(seatManager.reserve()).isEqualTo(1);
  }

  @Test
  void name() {

    SeatManagerWithSet seatManager = new SeatManagerWithSet(3);

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