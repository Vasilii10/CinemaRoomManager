package ru.nazarenko.jetbrains.academy.cinema;


/**
 * Менеджер
 * и что же он делает ?
 */

public class CinemaManagerService {

    private final RoomDimensions roomDimensions;
    private final RoomBookingStorage roomBookingStorage;
    private final int roomLimit;
    private int numberOfBookedTickets = 0;

    public CinemaManagerService(RoomDimensions roomDimensions, Configuration configuration) {
        this.roomDimensions = roomDimensions;
        this.roomBookingStorage = new RoomBookingStorage(roomDimensions);
        this.roomLimit = configuration.getRoomLimit();

        roomBookingStorage.initBookingStorage(roomBookingStorage, roomDimensions);
    }

    public Booking bookSeatBy(SeatLocation seatLocation) throws BookingException {
        roomBookingStorage.bookSeatBy(seatLocation);
        numberOfBookedTickets++;

        return new Booking(definePriceBy(seatLocation).getIntValue(), seatLocation);
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
        return (roomDimensions.getRowLength() * roomDimensions.getNumberOfSeatsInRow()) <= roomLimit;
    }

    protected RoomBookingStorage getRoomBookingStorage() {
        return this.roomBookingStorage;
    }

    protected RoomDimensions getRoomDimensions() {
        return roomDimensions;
    }

    protected int getNumberOfBookedTickets() {
        return numberOfBookedTickets;
    }

    protected int getRoomLimit() {
        return roomLimit;
    }
}
