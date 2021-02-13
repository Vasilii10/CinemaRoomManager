package ru.nazarenko.jetbrains.academy.cinema;

public class IncorrectSeatLocationException extends BookingException {

    public IncorrectSeatLocationException() {
    }

    public IncorrectSeatLocationException(String message) {
        super(message);
    }

    public IncorrectSeatLocationException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectSeatLocationException(Throwable cause) {
        super(cause);
    }

    public IncorrectSeatLocationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
