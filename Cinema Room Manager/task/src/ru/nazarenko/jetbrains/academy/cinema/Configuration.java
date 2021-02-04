package ru.nazarenko.jetbrains.academy.cinema;

public class Configuration {

    private final int roomLimit;
    private final char currencySymbol;

    public Configuration(char currencySymbol, int roomLimit) {
        this.currencySymbol = currencySymbol;
        this.roomLimit = roomLimit;
    }

    public int getRoomLimit() {
        return roomLimit;
    }

    public char getCurrencySymbol() {
        return currencySymbol;
    }
}
