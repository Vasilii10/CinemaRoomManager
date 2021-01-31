package cinema;


/**
 * Класс для обеспечения хранения представления зала с забронированными местами в виде чар двумерного массива
 */
public class RoomSeatsCapacity {
    // может boolean это сделать ?
    private final char[][] capacity; // тип память для хранения кто что забронил
    private final int row;
    private final int seats;

    public RoomSeatsCapacity(int row, int seats) {
        this.row = row;
        this.seats = seats;
        this.capacity = new char[row][seats];
    }

    public void initBookingStorage(RoomSeatsCapacity roomSeatsCapacity, RoomDimensions roomDimensions) {
        for (int i = 0; i < roomDimensions.getRowLength(); i++) {
            for (int j = 0; j < roomDimensions.getSeatsInRow(); j++) {
                roomSeatsCapacity.capacity[i][j] = 'S';
            }
        }
    }

    public char[][] getCapacity() {
        return capacity;
    }

    public int getRow() {
        return row;
    }

    public int getSeats() {
        return seats;
    }

    /**
     * @return false if seat occupied
     */
// TODO: 31/01/2021 можно добавить какое-то исключеие напрмер что заронирвоано уже!
    // или вывести что-нибудь на экран
    public boolean addBookingBy(SeatLocation seatLocation) {
        if (seatIsNotBooked(seatLocation)) {
            this.capacity[seatLocation.row - 1][seatLocation.seat - 1] = 'B';
            return true;
        } else {
            return false;
        }
    }

    private boolean seatIsNotBooked(SeatLocation seatLocation) {
        return this.capacity[seatLocation.row - 1][seatLocation.seat - 1] != 'B';
    }
}
