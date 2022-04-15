package com.giuseppe.pinto;

import com.giuseppe.pinto.exception.NotAvailableSeatsException;

import java.util.SortedSet;
import java.util.TreeSet;

public class SeatManagerWithSet {


  private int availableSeats;

  SortedSet<Integer> freeTreeSet = new TreeSet<>();
  SortedSet<Integer> busyTreeSet = new TreeSet<>();

  public SeatManagerWithSet(int availableSeats) {
    this.availableSeats = availableSeats;
  }

  public int reserve() {

    if (availableSeats > 0) {

      if (freeTreeSet.isEmpty()) {
        int lastIndexAvailable = busyTreeSet.isEmpty() ? 1 : busyTreeSet.last() + 1;
        busyTreeSet.add(lastIndexAvailable);
        availableSeats--;
        return lastIndexAvailable;
      } else {
        Integer free = freeTreeSet.first();
        freeTreeSet.remove(free);
        busyTreeSet.add(free);
        availableSeats--;
        return free;
      }

    } else {
      throw new NotAvailableSeatsException("There are no more available seats");
    }

  }

  public void unreserve(int seatNumber) {

    if (busyTreeSet.isEmpty()) {
      throw new RuntimeException("You cannot un reserve a place before to reserve a place");
    } else {
      busyTreeSet.remove(seatNumber);
      freeTreeSet.add(seatNumber);
    }
    availableSeats = availableSeats + 1;
  }

}
