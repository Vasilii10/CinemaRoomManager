package cinema.services;

import cinema.RoomDimensions;
import cinema.SeatLocation;
import cinema.services.presenter.CinemaSchemePresenter;
import cinema.services.presenter.ConsoleCinemaSchemePresenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Сервис бронирования
 */
public class CinemaBookingService {

    private final CinemaManagerService cinemaManagerService;

    public CinemaBookingService(RoomDimensions roomDimensions) {
        this.cinemaManagerService = new CinemaManagerService(roomDimensions);
    }

    public void startWorkWithCinemaBy() throws IOException {
        putMenuToConsole();
        defineMenuActionFor(cinemaManagerService);
    }

    private void putMenuToConsole() {
        System.out.println();
        System.out.println("1. " + "Show the seats");
        System.out.println("2. " + "Buy a ticket");
        System.out.println("0. Exit");
        System.out.print(">");
    }

    private void defineMenuActionFor(CinemaManagerService cinemaManagerService) throws IOException {
        switch (getMenuChoice()) {
            case 1:
                System.out.println();

                CinemaSchemePresenter cinemaSchemePresenter = new ConsoleCinemaSchemePresenter(
                        cinemaManagerService.getRoomBookingStorage());

                cinemaSchemePresenter.printScheme();
                System.out.println();
                break;

            case 2:
                SeatLocation seatLocation = SeatLocation.getSeatLocationFromConsole();

                System.out.println();
                cinemaManagerService.printTicketPriceBy(seatLocation);
                cinemaManagerService.bookSeatBy(seatLocation);
                break;

            case 0:
                return;
        }
        putMenuToConsole();
        defineMenuActionFor(cinemaManagerService);

    }

    private int getMenuChoice() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(reader.readLine());
    }

}
