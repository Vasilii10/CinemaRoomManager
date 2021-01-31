package cinema;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CinemaCashierService {

    CinemaManagerService cinemaManagerService;

    public CinemaCashierService() {
    }

    private static void showMenuToConsole() {
        System.out.println();
        System.out.println("1. " + "Show the seats");
        System.out.println("2. " + "Buy a ticket");
        System.out.println("0. Exit");
        System.out.print(">");
    }

    public void startBuyTicket() throws IOException {
        RoomDimensions roomDimensions = DimensionsReaderClass.readRoomDimensionsFromConsole();

        this.cinemaManagerService = new CinemaManagerService(roomDimensions);


        showMenuToConsole();

        defineActionAfterMenu(cinemaManagerService);

//        ConsoleCinemaPresenter consoleCinemaPresenter = new ConsoleCinemaPresenter();
//        System.out.println();
//        consoleCinemaPresenter.presentScheme(roomDimensions);
//        System.out.println();
//
//        SeatLocation seatLocation = SeatLocation.getSeatLocationFromConsole();
//
//        System.out.println();
//        cinemaManagerService.printTicketPriceBy(seatLocation);
//
//        System.out.println();
//        consoleCinemaPresenter.presentBookedSeatOnTheScheme(roomDimensions, seatLocation);
    }

    private void defineActionAfterMenu(CinemaManagerService cinemaManagerService) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int menuChoice = Integer.parseInt(reader.readLine());

        switch (menuChoice) {
            case 1:

                // отобржание из памяти

                ConsoleCinemaPresenter consoleCinemaPresenter = new ConsoleCinemaPresenter();
                System.out.println();
//cinemaManagerService.
                cinemaManagerService.printSchemeWithBookingsToConsole();
                //consoleCinemaPresenter.presentScheme(cinemaManagerService.getRoomDIMENTIONS()); // TODO: 31/01/2021 если номер ряда больше 10 то сделать плюс еще один пробел
                System.out.println();

                break;
            case 2:

                SeatLocation seatLocation = SeatLocation.getSeatLocationFromConsole();

                System.out.println();
                cinemaManagerService.printTicketPriceBy(seatLocation);

                cinemaManagerService.bookSeat(seatLocation);

//                ConsoleCinemaPresenter consoleCinemaPresenter2 = new ConsoleCinemaPresenter(); // FIXME: 31/01/2021 у каждого свой презентер?
//                consoleCinemaPresenter2.presentBookedSeatOnTheScheme(cinemaManagerService.getRoomDIMENTIONS(), seatLocation);


                break;
            case 0:
                return;

        }

        showMenuToConsole();
        defineActionAfterMenu(cinemaManagerService);

    }


}
