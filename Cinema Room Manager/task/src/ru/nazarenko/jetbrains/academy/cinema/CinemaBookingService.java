package ru.nazarenko.jetbrains.academy.cinema;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Сервис бронирования
 */
public class CinemaBookingService {

    private final CinemaManagerService cinemaManagerService;
    private final ArrayList<Booking> bookingsList = new ArrayList<>();
    private final char currencySymbol;

    public CinemaBookingService(Configuration configuration, RoomDimensions roomDimensions) {
        this.cinemaManagerService = new CinemaManagerService(roomDimensions, configuration);
        this.currencySymbol = configuration.getCurrencySymbol();
    }

    public void startWorkWithCinemaBy() throws IOException {
        putMenuToConsole();
        defineMenuActionFor(cinemaManagerService);
    }

    private void putMenuToConsole() {
        System.out.println();
        System.out.println("1. " + "Show the seats");
        System.out.println("2. " + "Buy a ticket");
        System.out.println("3. " + "Statistics");
        System.out.println("0. Exit");
        System.out.print(">");
    }

    private void defineMenuActionFor(CinemaManagerService cinemaManagerService) throws IOException {
        Booking booking = null;

        switch (getMenuChoice()) {
            case 1:
                System.out.println();

                CinemaSchemePresenter cinemaSchemePresenter = new ConsoleCinemaSchemePresenter(
                        cinemaManagerService.getRoomBookingStorage());

                cinemaSchemePresenter.printScheme();
                System.out.println();
                break;

            case 2:
                while (true) {
                    SeatLocation seatLocation = SeatLocation.getSeatLocationFromConsole();

                    System.out.println();
                    try {

                        booking = cinemaManagerService.bookSeatBy(seatLocation);
                        bookingsList.add(booking);

                        printPriceFor(booking);

                        break;
                    } catch (SeatIsAlreadyBookedException e) {
                        System.out.println("That ticket has already been purchased!");
                    } catch (IncorrectSeatLocationException incorrectSeatLocationException) {
                        System.out.println("Wrong input!");
                    } catch (BookingException e) {

                    }
                }
                break;

            case 3:
                StatisticsService statisticsService = new StatisticsService(cinemaManagerService);

                System.out.println("Number of purchased tickets: " + statisticsService.numberOfPurchasedTickets());
                System.out.println("Percentage: " + String.format("%.2f", statisticsService.FullnessPercentage()) + "%");
                System.out.println("Current income: " + "$" + statisticsService.calculateCurrentIncomeBy(bookingsList));
                System.out.println("Total income: " + "$" + statisticsService.countTotalIncomeIfRoomFull());

                break;

            case 0:
                return;
        }

        putMenuToConsole();
        defineMenuActionFor(cinemaManagerService);

    }

    private void printPriceFor(Booking booking) {
        System.out.println("Ticket price: " + currencySymbol + booking.getPrice());
    }

    private int getMenuChoice() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(reader.readLine());
    }

}
