package ru.nazarenko.jetbrains.academy.cinema;

public class Booking { // бронирование
    private int price;
    private SeatLocation seatLocation;
    private int numberOfRoom;


    public Booking(int price, SeatLocation seatLocation) {
        this.price=price;
        this.seatLocation =  seatLocation;
    }

    public int getPrice() {
        return price;
    }

    public SeatLocation getSeatLocation() {
        return seatLocation;
    }
}
