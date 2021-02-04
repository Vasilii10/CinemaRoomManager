package ru.nazarenko.jetbrains.academy.cinema;

public enum TicketPrice {

    FIRST_PART_PRICE(10),
    SECOND_PART_PRICE(8);

    private final int price;

    TicketPrice(int price) {
        this.price = price;
    }

    public int getIntValue() {
        return price;
    }
}
