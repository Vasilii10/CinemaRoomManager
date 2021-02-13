package ru.nazarenko.jetbrains.academy.cinema;

import java.io.IOException;

public class Cinema {
    public static void main(String[] args) {

        Configuration configuration = new Configuration('\u0024',60);

        try {

            new CinemaBookingService(
                    configuration,
                    DimensionsReaderService.readRoomDimensionsFromConsole()
            ).startWorkWithCinemaBy();

        } catch (IOException e) {
            System.err.println("Application error!");
        }
    }
}