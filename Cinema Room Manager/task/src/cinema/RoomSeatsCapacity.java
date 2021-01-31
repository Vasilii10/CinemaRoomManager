package cinema;


/**
 * Класс для обеспечения хранения представления зала с забронированными местами в виде чар двумерного массива
 */
public class RoomSeatsCapacity {

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

//    public void printToConsole() {
//
//        System.out.println("Cinema:");
//
//        for (int i = 0; i < row; i++) {
//
//            if (i == 0){
//                presentNumnerOfSeatsToConsole();
//            } else {
//
//                for (int j = 0; j < seats; j++) {
//                    System.out.print(this.capacity[i][j] + " ");
//                }
//            }
//
//
//            System.out.println();
//        }
//    }

    private void presentNumnerOfSeatsToConsole() {


        for (int i = 0; i <= row; i++) {
            if (i == 0) {
                printFirstLineFrom(seats);
            } else {
                // fillCinemaSeat(seats, i);
            }
        }
    }

    public void printToConsole() {

        System.out.println("Cinema:");

        for (int i = 0; i <= row; i++) {
            if (i == 0) {
                printFirstLineFrom(seats);
            } else {
                fillCinemaSeat(seats, i);
            }
        }


    }


//    public void printToConsole() {
//
//        System.out.println("Cinema:");
//
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < seats; j++) {
//                System.out.print(this.capacity[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }


    /**
     * тип возвращает true если удалось записать бронирвоание в схему
     */
// TODO: 31/01/2021 можно добавить какое-то исключеие напрмер что заронирвоано уже!
    public boolean addBookingBy(SeatLocation seatLocation) {

        if (this.capacity[seatLocation.row - 1][seatLocation.seat - 1] != 'B') {
            this.capacity[seatLocation.row - 1][seatLocation.seat - 1] = 'B';
            return true; // забронировали
        } else {
            return false;
            // System.err.println("Seat is booked!");
        }
    }

    private void printFirstLineFrom(int numberOfSeatsInRow) {
        for (int j = 1; j <= numberOfSeatsInRow; j++) {
            if (j == 1) {
                System.out.print("  " + j + " ");
            } else if (j == numberOfSeatsInRow) {
                System.out.println(j + " ");
            } else {
                System.out.print(j + " ");
            }
        }
    }

    private void fillCinemaSeat(int numberOfSeatsInRow, int i) {
        for (int index = 1; index <= numberOfSeatsInRow + 1; index++) {
            if (index == 1) {
                System.out.print(i + " ");
            } else if (index == numberOfSeatsInRow + 1) {
                System.out.print(capacity[i - 1][index - 2] + "\n");
            } else if (index < numberOfSeatsInRow + 1) {
                System.out.print(capacity[i - 1][index - 2] + " ");
            }
        }
    }
}
