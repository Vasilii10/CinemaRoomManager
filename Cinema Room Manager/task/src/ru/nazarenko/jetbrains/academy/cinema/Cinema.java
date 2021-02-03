package ru.nazarenko.jetbrains.academy.cinema;


import ru.nazarenko.jetbrains.academy.cinema.services.CinemaBookingService;
import ru.nazarenko.jetbrains.academy.cinema.services.DimensionsReaderService;

import java.io.IOException;

public class Cinema {
    public static void main(String[] args) {

        Configuration configuration = new Configuration('\u0024',60);

        try {

            new CinemaBookingService(
                    DimensionsReaderService.readRoomDimensionsFromConsole(), configuration
            ).startWorkWithCinemaBy();

        } catch (IOException e) {
            System.err.println("Application error!");
        }
    }
}