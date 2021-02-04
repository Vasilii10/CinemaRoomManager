package ru.nazarenko.jetbrains.academy.cinema;


import java.util.ArrayList;

public class StatisticsService {

    CinemaManagerService cinemaManagerService;

    public StatisticsService(CinemaManagerService cinemaManagerService) {
        this.cinemaManagerService = cinemaManagerService;
    }

    public int calculateCurrentIncomeBy(ArrayList<Booking> bookings) {
        int income = 0;
        for (Booking booking : bookings) {
            income += booking.getPrice();
        }

        return income;
    }

    public int numberOfPurchasedTickets() {
        return cinemaManagerService.getNumberOfBookedTickets();
    }

    public double FullnessPercentage() {
        return (double) cinemaManagerService.getNumberOfBookedTickets() * 100 /
                (double) cinemaManagerService.getRoomDimensions().getTotalNumberOfSeats();
    }

    public int countTotalIncomeIfRoomFull() {
        RoomDimensions roomDimensions = cinemaManagerService.getRoomDimensions();

        int cinemaCapacity = roomDimensions.getRowLength() * roomDimensions.getNumberOfSeatsInRow();

        if (cinemaRoomHasOnePrice(roomDimensions)) {
            return TicketPrice.FIRST_PART_PRICE.getIntValue() * cinemaCapacity;
        } else {
            int halfRows = roomDimensions.getRowLength() / 2;
            int seatsInRow = roomDimensions.getNumberOfSeatsInRow();

            int totalCostOfFirstPart;
            int totalCostOfSecondPart;

            if (roomDimensions.getRowLength() % 2 != 0) {  //
                totalCostOfFirstPart = seatsInRow * halfRows * TicketPrice.FIRST_PART_PRICE.getIntValue();
                totalCostOfSecondPart = (halfRows + 1) * seatsInRow * TicketPrice.SECOND_PART_PRICE.getIntValue();
            } else {
                totalCostOfFirstPart = seatsInRow * halfRows * TicketPrice.FIRST_PART_PRICE.getIntValue();
                totalCostOfSecondPart = seatsInRow * halfRows * TicketPrice.SECOND_PART_PRICE.getIntValue();
            }

            return totalCostOfFirstPart + totalCostOfSecondPart;
        }
    }

    private boolean cinemaRoomHasOnePrice(RoomDimensions roomDimensions) {
        return (roomDimensions.getRowLength() * roomDimensions.getNumberOfSeatsInRow()) <= cinemaManagerService.getRoomLimit();
    }

}
