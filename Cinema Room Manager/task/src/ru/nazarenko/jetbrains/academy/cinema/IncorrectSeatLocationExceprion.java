package ru.nazarenko.jetbrains.academy.cinema;

public class IncorrectSeatLocationExceprion extends Exception {

    public IncorrectSeatLocationExceprion() {
    }

    public IncorrectSeatLocationExceprion(String message) {
        super(message);
    }

    public IncorrectSeatLocationExceprion(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectSeatLocationExceprion(Throwable cause) {
        super(cause);
    }

    public IncorrectSeatLocationExceprion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
