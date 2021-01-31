package cinema;


/**
 * Класс для обеспечения хранения представления зала с забронированными местами в виде чар двумерного массива
 */
public class RoomBookingStorage {

    private final char[][] roomBookingStorage; // тип память для хранения кто что забронил
    private final int row;
    private final int seats;

    public RoomBookingStorage(RoomDimensions roomDimensions) {
        this.row = roomDimensions.getRowLength();
        this.seats = roomDimensions.getSeatsInRow();
        this.roomBookingStorage = new char[row][seats];
    }

    public void initBookingStorage(RoomBookingStorage roomBookingStorage, RoomDimensions roomDimensions) {
        for (int i = 0; i < roomDimensions.getRowLength(); i++) {
            for (int j = 0; j < roomDimensions.getSeatsInRow(); j++) {
                roomBookingStorage.roomBookingStorage[i][j] = 'S';
            }
        }
    }

    /**
     * @return false if seat occupied
     */
// TODO: 31/01/2021 можно добавить какое-то исключеие напрмер что заронирвоано уже!
    // или вывести что-нибудь на экран
    public boolean bookSeatBy(SeatLocation seatLocation) {
        if (seatIsNotBooked(seatLocation)) {
            this.roomBookingStorage[seatLocation.getRow() - 1][seatLocation.getSeat() - 1] = 'B';
            return true;
        } else {
            return false;
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
