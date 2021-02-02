package ru.nazarenko.jetbrains.academy.cinema;

public class SeatIsAlreadyBookedException extends Exception {

    public SeatIsAlreadyBookedException() {
    }

    public SeatIsAlreadyBookedException(String message) {
        super(message);
    }

    public SeatIsAlreadyBookedException(String message, Throwable cause) {
        super(message, cause);
    }
}
