package com.giuseppe.pinto;

import com.giuseppe.pinto.exception.NotAvailableSeatsException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SeatManager {

  private final int availableSeats;
  private final Map<Integer, String> map = new HashMap<>();

  public SeatManager(int availableSeats) {
    this.availableSeats = availableSeats;
    init();
  }

  private void init() {
    for (int i = 1; i <= availableSeats; i++) {
      map.put(i, "free");
    }
  }

  public int reserve() {

    Map.Entry<Integer, String> firstAvailableSeat = map.entrySet()
            .stream()
            .filter(entry -> Objects.equals(entry.getValue(), "free"))
            .findFirst()
            .orElseThrow(() -> new NotAvailableSeatsException("There are no seats available"));

    System.out.println("Available seat number " + firstAvailableSeat);

    map.put(firstAvailableSeat.getKey(), "occupied");

    return firstAvailableSeat.getKey();
  }

  public void unreserve(int seatNumber) {

    if("occupied".equals(map.get(seatNumber))){
      map.put(seatNumber, "free");
    }

  }

  public int getAvailableSeats() {
    return availableSeats;
  }

}
