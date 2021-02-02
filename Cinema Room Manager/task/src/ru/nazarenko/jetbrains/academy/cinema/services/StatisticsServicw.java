package ru.nazarenko.jetbrains.academy.cinema.services;

import ru.nazarenko.jetbrains.academy.cinema.Booking;

import java.util.ArrayList;

public class StatisticsServicw {
    private int numberOfPurchasedTickets;
    private double percentage;
    private double currentIncome;
    private double totalIncome;
    CinemaManagerService cinemaManagerService;

    public StatisticsServicw(CinemaManagerService cinemaManagerService) {
        this.cinemaManagerService = cinemaManagerService;
    }

    public int currentIncome(ArrayList<Booking> bookings) { // считаем для всех
        int income = 0;
        for (Booking booking: bookings
             ) {
            income+=booking.getPrice();
        }
        return income;
    }

    public int numberOfPurshcasedTickets(){
        return cinemaManagerService.getCountOfBookedTickets();
    }

    public double percentage(){
        return (double) cinemaManagerService.getCountOfBookedTickets() * 100 / (double) cinemaManagerService.getRoomDimensions().getTotalNumberOfSeats();
    }

    public int tptalIncome() { //if all the tickets are sold
        return  cinemaManagerService.calculateTotalIncomeFromRoom();
    }
}
