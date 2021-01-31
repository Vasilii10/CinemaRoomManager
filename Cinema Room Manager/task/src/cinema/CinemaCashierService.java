package cinema;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Сервис иммитирующий кассира
 */
public class CinemaCashierService {

    private final CinemaManagerService cinemaManagerService; // у каждого кассира есть свой менеджер

    public CinemaCashierService(RoomDimensions roomDimensions) {
        this.cinemaManagerService = new CinemaManagerService(roomDimensions);
    }

    public void startWorkWithCinemaBy() throws IOException {
        printMenuToConsole();

        defineMenuAction(cinemaManagerService);
    }

    private void printMenuToConsole() {
        System.out.println();
        System.out.println("1. " + "Show the seats");
        System.out.println("2. " + "Buy a ticket");
        System.out.println("0. Exit");
        System.out.print(">");
    }

    private void defineMenuAction(CinemaManagerService cinemaManagerService) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int menuChoice = Integer.parseInt(reader.readLine());

        switch (menuChoice) {
            case 1:

                System.out.println();

                SchemePresenter schemePresenter = new ConsoleCinemaPresenter();

                schemePresenter.printSchemeFrom(cinemaManagerService.getRoomSeatsCapacity());


                System.out.println();

                break;
            case 2:

                SeatLocation seatLocation = SeatLocation.getSeatLocationFromConsole();

                System.out.println();
                cinemaManagerService.printTicketPriceBy(seatLocation);

                cinemaManagerService.bookSeat(seatLocation);

                break;
            case 0:
                return;

        }
        printMenuToConsole();
        defineMenuAction(cinemaManagerService);

    }


}
