package ru.nazarenko.jetbrains.academy.cinema.services;


import ru.nazarenko.jetbrains.academy.cinema.*;


public class CinemaManagerService {

    private static final int PRICE_FOR_FIRST_PART_OF_ROOM = 10; // может тариф сделать
    private static final int PRICE_FOR_SECOND_PART_OF_ROOM = 8; // класс тип


    private static final char CURRENCY_SYMBOL = '\u0024';
    private static final int SMALL_ROOM_LIMIT = 60;
    private RoomDimensions roomDimensions;
    private RoomBookingStorage roomBookingStorage;

    private int countOfBookedTickets = 0;


    public RoomDimensions getRoomDimensions() {
        return roomDimensions;
    }

    public CinemaManagerService(RoomDimensions roomDimensions) {
        this.roomDimensions = roomDimensions;
        this.roomBookingStorage = new RoomBookingStorage(roomDimensions);

        roomBookingStorage.initBookingStorage(roomBookingStorage, roomDimensions);
    }

    private boolean cinemaRoomHasOnePrice() {
        return (roomDimensions.getRowLength() * roomDimensions.getNumberOfSeatsInRow()) <= SMALL_ROOM_LIMIT;
    }

    public int calculateTotalIncomeFromRoom() {
        int cinemaCapacity = roomDimensions.getRowLength() * roomDimensions.getNumberOfSeatsInRow();

        if (cinemaRoomHasOnePrice()) {
            return PRICE_FOR_FIRST_PART_OF_ROOM * cinemaCapacity;
        } else {
            int halfRows = roomDimensions.getRowLength() / 2;
            int seatsInRow = roomDimensions.getNumberOfSeatsInRow();

            int totalCostOfFirstPart;
            int totalCostOfSecondPart;

            if (isASimpleHalf()) {
                totalCostOfFirstPart = seatsInRow * halfRows * PRICE_FOR_FIRST_PART_OF_ROOM;
                totalCostOfSecondPart = (halfRows + 1) * seatsInRow * PRICE_FOR_SECOND_PART_OF_ROOM;
            } else {
                totalCostOfFirstPart = seatsInRow * halfRows * PRICE_FOR_FIRST_PART_OF_ROOM;
                totalCostOfSecondPart = seatsInRow * halfRows * PRICE_FOR_SECOND_PART_OF_ROOM;
            }

            return totalCostOfFirstPart + totalCostOfSecondPart;
        }
    }

    private boolean isASimpleHalf() {
        return roomDimensions.getRowLength() % 2 != 0;
    }


    //// TODO: 01/02/2021 он должен только отдавать, а печатеает пусть кто-то другой
    public void printTicketPriceBy(SeatLocation seatLocation) {
        System.out.println("Ticket price: " + CURRENCY_SYMBOL + definePriceBy(seatLocation));
    }

    private int definePriceBy(SeatLocation seatLocation) {
        if (cinemaRoomHasOnePrice()) {
            return PRICE_FOR_FIRST_PART_OF_ROOM;
        } else {
            int halfRows = roomDimensions.getRowLength() / 2;
            if (seatLocation.getRow() <= halfRows) {
                return PRICE_FOR_FIRST_PART_OF_ROOM;
            } else {
                return PRICE_FOR_SECOND_PART_OF_ROOM;
            }
        }
    }

    public RoomBookingStorage getRoomBookingStorage() {
        return this.roomBookingStorage;
    }

    public Booking bookSeatBy(SeatLocation seatLocation) throws SeatIsAlreadyBookedException, IncorrectSeatLocationExceprion {
        roomBookingStorage.bookSeatBy(seatLocation);
        countOfBookedTickets++;

        return new Booking(definePriceBy(seatLocation) , seatLocation);

    }

    public int getCountOfBookedTickets() {
        return countOfBookedTickets;
    }
}
