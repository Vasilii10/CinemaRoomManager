package cinema;

public class ConsoleCinemaPresenter implements SchemePresenter {

    // TODO: 31/01/2021 здесь 100% нужно поработаь над алгоритмом

    // FIXME: 31/01/2021 проблема в некорректном отображении при бронировании последнего места в ряду

    private RoomSeatsCapacity roomSeatsCapacity;

    @Override
    public void printSchemeFrom(RoomSeatsCapacity roomSeatsCapacity) {

        this.roomSeatsCapacity = roomSeatsCapacity;
        printToConsole();
    }

    public void printToConsole() {
        System.out.println("Cinema:");
        for (int i = 0; i <= roomSeatsCapacity.getRow(); i++) {
            if (i == 0) {
                printFirstLineFrom(roomSeatsCapacity.getSeats());
            } else {
                fillCinemaSeat(roomSeatsCapacity.getSeats(), i);
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

    private void fillCinemaSeat(int numberOfSeatsInRow, int i) {
        for (int index = 1; index <= numberOfSeatsInRow + 1; index++) {
            if (index == 1) {
                System.out.print(i + " ");
            } else if (index == numberOfSeatsInRow + 1) {
                System.out.print(roomSeatsCapacity.getCapacity()[i - 1][index - 2] + "\n");
            } else if (index < numberOfSeatsInRow + 1) {
                System.out.print(roomSeatsCapacity.getCapacity()[i - 1][index - 2] + " ");
            }
        }
    }

    @Override
    public void presentBookedSeatOnTheScheme(RoomDimensions roomDimensions, SeatLocation seatLocation) {


        int targetRowIndex = seatLocation.getRow();
        int targetSeatIndex = seatLocation.getSeat() + 1;

        int numberOfRows = roomDimensions.getRowLength();
        int numberOfSeatsInRow = roomDimensions.getSeatsInRow();

        System.out.println("Cinema:");
        for (int i = 0; i <= numberOfRows; i++) {
            if (i == 0) {
                printFirstLineFrom(numberOfSeatsInRow);
            } else if (i == targetRowIndex) {
                for (int index = 1; index <= numberOfSeatsInRow + 1; index++) {

                    if (index == targetSeatIndex) {
                        System.out.print("B ");
                    } else {
                        if (index == 1) {
                            System.out.print(i + " ");
                        } else if (index == numberOfSeatsInRow + 1) { //todo а если место последнее?/?/
                            System.out.print("S " + "\n");
                        } else if (index < numberOfSeatsInRow + 1) {
                            System.out.print("S ");
                        }
                    }
                }
            } else {
                fillCinemaSeat(numberOfSeatsInRow, i);
            }
        }


    }

}
