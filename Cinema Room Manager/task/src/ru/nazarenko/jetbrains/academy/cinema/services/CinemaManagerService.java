package ru.nazarenko.jetbrains.academy.cinema.services;


import ru.nazarenko.jetbrains.academy.cinema.*;

/**
 * что делаем менеджер?
 */

public class CinemaManagerService {

    private final RoomDimensions roomDimensions;
    private final RoomBookingStorage roomBookingStorage;
    private final Configuration configuration;
    private int countOfBookedTickets = 0;

    public CinemaManagerService(RoomDimensions roomDimensions, Configuration configuration) {
        this.roomDimensions = roomDimensions;
        this.roomBookingStorage = new RoomBookingStorage(roomDimensions);
        this.configuration = configuration;

        roomBookingStorage.initBookingStorage(roomBookingStorage, roomDimensions);
    }

    public Booking bookSeatBy(SeatLocation seatLocation) throws SeatIsAlreadyBookedException,
            IncorrectSeatLocationExceprion {
        roomBookingStorage.bookSeatBy(seatLocation);
        countOfBookedTickets++;

        return new Booking(definePriceBy(seatLocation).getIntValue(), seatLocation);
    }

    //// TODO: 01/02/2021 он должен только отдавать, а печатеает пусть кто-то другой
    public void printTicketPriceBy(SeatLocation seatLocation) {
        System.out.println("Ticket price: " + configuration.getCurrencySymbol() + (definePriceBy(seatLocation).getIntValue()));
    }

    private TicketPrice definePriceBy(SeatLocation seatLocation) {
        if (cinemaRoomHasOnePrice()) {
            return TicketPrice.FIRST_PART_PRICE;
        } else {
            int halfRows = roomDimensions.getRowLength() / 2;
            if (seatLocation.getRow() <= halfRows) {
                return TicketPrice.FIRST_PART_PRICE;
            } else {
                return TicketPrice.SECOND_PART_PRICE;
            }
        }
    }

    private boolean cinemaRoomHasOnePrice() {
        return (roomDimensions.getRowLength() * roomDimensions.getNumberOfSeatsInRow()) <= configuration.getRoomLimit();
    }

    RoomBookingStorage getRoomBookingStorage() {
        return this.roomBookingStorage;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public RoomDimensions getRoomDimensions() {
        return roomDimensions;
    }

    public int getCountOfBookedTickets() {
        return countOfBookedTickets;
    }
}
