package cinema.services.presenter;

import cinema.RoomBookingStorage;

public class ConsoleCinemaSchemePresenter implements CinemaSchemePresenter {

    private final RoomBookingStorage roomBookingStorage;

    public ConsoleCinemaSchemePresenter(RoomBookingStorage roomBookingStorage) {
        this.roomBookingStorage = roomBookingStorage;
    }

    @Override
    public void printScheme() {
        printToConsole();
    }

    public void printToConsole() {
        System.out.println("Cinema:");
        for (int i = 0; i <= roomBookingStorage.getRow(); i++) {
            if (i == 0) {
                printFirstLineFrom(roomBookingStorage.getSeats());
            } else {
                fillSchemaIn(roomBookingStorage.getSeats(), i);
            }
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

    private void fillSchemaIn(int numberOfSeatsInRow, int i) {
        for (int index = 1; index <= numberOfSeatsInRow + 1; index++) {
            if (index == 1) {
                System.out.print(i + " ");
            } else if (index == numberOfSeatsInRow + 1) {
                System.out.print(roomBookingStorage.getRoomBookingStorage()[i - 1][index - 2] + "\n");
            } else if (index < numberOfSeatsInRow + 1) {
                System.out.print(roomBookingStorage.getRoomBookingStorage()[i - 1][index - 2] + " ");
            }
        }
    }

}
