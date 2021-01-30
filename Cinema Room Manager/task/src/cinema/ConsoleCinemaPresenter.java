package cinema;

public class ConsoleCinemaPresenter implements SchemePresenter {
    @Override
    public void presentScheme(int numberOfRows, int numberOfSeatsInRow) {
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
}
