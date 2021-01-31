package ru.nazarenko.jetbrains.academy.cinema;

public class RoomDimensions {
    private final int rowLength;
    private final int seatsInRow;

    public RoomDimensions(int rowLength, int seatsInRow) {
        this.rowLength = rowLength;
        this.seatsInRow = seatsInRow;
    }

    public int getRowLength() {
        return rowLength;
    }

    public int getNumberOfSeatsInRow() {
        return seatsInRow;
    }
}
