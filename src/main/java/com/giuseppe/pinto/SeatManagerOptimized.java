package com.giuseppe.pinto;

import java.util.SortedSet;
import java.util.TreeSet;

public class SeatManagerOptimized {


  private int availableSeats;
  SortedSet<Integer> freeTreeSet = new TreeSet<>();
  SortedSet<Integer> busyTreeSet = new TreeSet<>();

  public SeatManagerOptimized(int availableSeats) {
    this.availableSeats = availableSeats;
  }

  public int reserve() {

    if (availableSeats > 0) {

      if (freeTreeSet.isEmpty()) {
        //if the free set is empty, we need to peek the first place from busySet or the last if it is not empty.
        int firstNotBusySeatAvailable = busyTreeSet.isEmpty() ? 1 : busyTreeSet.last() + 1;
        busyTreeSet.add(firstNotBusySeatAvailable);
        //decrease the counter for available seats
        availableSeats--;
        return firstNotBusySeatAvailable;
      } else {
        //if the free set is not empty, we need to peek the first place free remove it and put it into the busy one.
        Integer firstFreeSeatAvailable = freeTreeSet.first();
        freeTreeSet.remove(firstFreeSeatAvailable);
        busyTreeSet.add(firstFreeSeatAvailable);
        //decrease the counter for available seats
        availableSeats--;
        return firstFreeSeatAvailable;
      }

    } else {
      throw new RuntimeException("There are no more available seats");
    }

  }

  public void unreserve(int seatNumber) {

    if (busyTreeSet.isEmpty()) {
      throw new RuntimeException("You cannot un reserve a place before to reserve a place");
    } else {
      busyTreeSet.remove(seatNumber);
      freeTreeSet.add(seatNumber);
    }
    //increase the counter for available seats
    availableSeats = availableSeats + 1;
  }

}
