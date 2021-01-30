package cinema;

import cinema.profit.SeatLocation;

public class ConsoleCinemaPresenter implements SchemePresenter {
    @Override
    public void presentScheme(RoomDimensions roomDimensions) {


        int numberOfRows = roomDimensions.getRowLength();
        int numberOfSeatsInRow = roomDimensions.getSeatsInRow();

        System.out.println("Cinema:");

        for (int i = 0; i <= numberOfRows; i++) {
            if (i == 0) {
                for (int j = 1; j <= numberOfSeatsInRow; j++) {
                    if (j == 1) {
                        System.out.print("  " + j + " ");
                    } else if (j == numberOfSeatsInRow) {
                        System.out.println(j + " ");
                    } else {
                        System.out.print(j + " ");
                    }
                }
            } else {
                for (int index = 1; index <= numberOfSeatsInRow + 1; index++) {
                    if (index == 1) {
                        System.out.print(i + " ");
                    } else if (index == numberOfSeatsInRow + 1) {
                        System.out.print("S " + "\n");
                    } else if (index < numberOfSeatsInRow + 1) {
                        System.out.print("S ");
                    }
                }
            }
        }
    }

    @Override
    public void presentBookedSeatOnTheSheme(RoomDimensions roomDimensions, SeatLocation seatLocation) {

        int targetRowIndex = seatLocation.getRow();
        int targetSeatIndex = seatLocation.getSeat() + 1;

        int numberOfRows = roomDimensions.getRowLength();
        int numberOfSeatsInRow = roomDimensions.getSeatsInRow();

        System.out.println("Cinema:");
        for (int i = 0; i <= numberOfRows; i++) {
            if (i == 0) {
                for (int j = 1; j <= numberOfSeatsInRow; j++) {
                    if (j == 1) {
                        System.out.print("  " + j + " ");
                    } else if (j == numberOfSeatsInRow) {
                        System.out.println(j + " ");
                    } else {
                        System.out.print(j + " ");
                    }
                }
            } else if( i == targetRowIndex){
                for (int index = 1; index <= numberOfSeatsInRow + 1; index++) {

                    if ( index==targetSeatIndex){
                        System.out.print("B ");
                    } else {
                        if (index == 1) {
                            System.out.print(i + " ");
                        }


                        else if (index == numberOfSeatsInRow + 1) { //todo а если место последнее?/?/
                            System.out.print("S " + "\n");
                        } else if (index < numberOfSeatsInRow + 1) {
                            System.out.print("S ");
                        }
                    }


                }
            }


            else {
                for (int index = 1; index <= numberOfSeatsInRow + 1; index++) {
                    if (index == 1) {
                        System.out.print(i + " ");
                    } else if (index == numberOfSeatsInRow + 1) {
                        System.out.print("S " + "\n");
                    } else if (index < numberOfSeatsInRow + 1) {
                        System.out.print("S ");
                    }
                }
            }
        }
    }
}
