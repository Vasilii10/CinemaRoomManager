package ru.nazarenko.jetbrains.academy.cinema;


public class RoomBookingStorage {
    private final char[][] roomBookingStorage;
    private final int row;
    private final int seats;

    public RoomBookingStorage(RoomDimensions roomDimensions) {
        this.row = roomDimensions.getRowLength();
        this.seats = roomDimensions.getNumberOfSeatsInRow();
        this.roomBookingStorage = new char[row][seats];
    }

    public void initBookingStorage(RoomBookingStorage roomBookingStorage, RoomDimensions roomDimensions) {
        for (int i = 0; i < roomDimensions.getRowLength(); i++) {
            for (int j = 0; j < roomDimensions.getNumberOfSeatsInRow(); j++) {
                roomBookingStorage.roomBookingStorage[i][j] = 'S';
            }
        }
    }

    /**
     * @return false if seat occupied
     */


    // TODO: 02/02/2021 иерархи] исклбчений чтобы пробрасывать одно 
    public void bookSeatBy(SeatLocation seatLocation) throws SeatIsAlreadyBookedException, IncorrectSeatLocationExceprion {

        if (((seatLocation.getRow() > row) || (seatLocation.getRow() < 1)) || //// FIXME: 02/02/2021 убрать путаницу здесь
                ((seatLocation.getSeat() > seats) || (seatLocation.getSeat() < 1))) { // checkDemensions
            throw new IncorrectSeatLocationExceprion();
        } else {
            if (roomBookingStorage[seatLocation.getRow() - 1][seatLocation.getSeat() - 1] != 'B') {
                this.roomBookingStorage[seatLocation.getRow() - 1][seatLocation.getSeat() - 1] = 'B';
            } else {
                throw new SeatIsAlreadyBookedException();
            }
        }


    }

    private boolean seatIsNotBooked(SeatLocation seatLocation) {
        return this.roomBookingStorage[seatLocation.getRow() - 1][seatLocation.getSeat() - 1] != 'B';
    }

    public int getRow() {
        return row;
    }

    public int getSeats() {
        return seats;
    }

    public char[][] getRoomBookingStorage() {
        return roomBookingStorage;
    }
}
