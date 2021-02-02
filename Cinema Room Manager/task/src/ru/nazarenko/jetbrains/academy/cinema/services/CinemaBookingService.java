package ru.nazarenko.jetbrains.academy.cinema.services;

import ru.nazarenko.jetbrains.academy.cinema.*;
import ru.nazarenko.jetbrains.academy.cinema.services.presenter.CinemaSchemePresenter;
import ru.nazarenko.jetbrains.academy.cinema.services.presenter.ConsoleCinemaSchemePresenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Сервис бронирования
 */
public class CinemaBookingService {

    private final CinemaManagerService cinemaManagerService;

    ArrayList<Booking> bookings  = new ArrayList<>();

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


                while (true){
                    SeatLocation seatLocation = SeatLocation.getSeatLocationFromConsole();

                    System.out.println();
                    try {
                        booking =  cinemaManagerService.bookSeatBy(seatLocation);
                        bookings.add(booking); // и добавим
                        cinemaManagerService.printTicketPriceBy(seatLocation); // // TODO: 02/02/2021 переделать на метод класса Booking
                        break;
                    } catch (SeatIsAlreadyBookedException e) {
                        System.out.println("That ticket has already been purchased!");

                    } catch (IncorrectSeatLocationExceprion incorrectSeatLocationExceprion) {
                        System.out.println("Wrong input!");

                    }
                }



                break;

            case 3:

                StatisticsServicw statisticsServicw = new StatisticsServicw(cinemaManagerService);

               // System.out.println("Total income: " + statisticsServicw.calculateTotalIncome());
                System.out.println("Number of purchased tickets: " + statisticsServicw.numberOfPurshcasedTickets()); // works
                System.out.println("Percentage: " + String.format("%.2f", statisticsServicw.percentage())  + "%"); //works

                System.out.println("Current income: " + "$" + statisticsServicw.currentIncome(bookings));

                System.out.println("Total income: " + "$" + statisticsServicw.tptalIncome());

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
