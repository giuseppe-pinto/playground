Design a system that manages the reservation state of n seats that are numbered from 1 to n.

Implement the com.giuseppe.pinto.SeatManager class:

- com.giuseppe.pinto.SeatManager(int n) Initializes a com.giuseppe.pinto.SeatManager object that will manage n seats numbered from 1 to n. All seats are initially available.
- int reserve() Fetches the smallest-numbered unreserved seat, reserves it, and returns its number.
- void unreserve(int seatNumber) Unreserves the seat with the given seatNumber.