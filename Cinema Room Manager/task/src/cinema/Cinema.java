package cinema;


import cinema.services.CinemaBookingService;
import cinema.services.DimensionsReaderService;

import java.io.IOException;

public class Cinema {
    public static void main(String[] args) {

        try {

            new CinemaBookingService(
                    DimensionsReaderService.readRoomDimensionsFromConsole()
            ).startWorkWithCinemaBy();

        } catch (IOException e) {
            System.err.println("Application error!");
        }
    }
}