package ru.nazarenko.jetbrains.academy.cinema;

public class Booking {
    private final int price;
    private final SeatLocation seatLocation;

    public Booking(int price, SeatLocation seatLocation) {
        this.price = price;
        this.seatLocation = seatLocation;
    }

    public int getPrice() {
        return price;
    }

    public SeatLocation getSeatLocation() {
        return seatLocation;
    }

}
