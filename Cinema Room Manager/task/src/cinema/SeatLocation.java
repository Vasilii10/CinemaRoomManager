package cinema;

import java.util.Scanner;

public class SeatLocation {
    int row;
    int seat;

    public SeatLocation(int row, int seat) {
        this.row = row;
        this.seat = seat;
    }

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public static SeatLocation getSeatLocationFromConsole() {
        SeatLocation seatLocation = null;
        int row, seat;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a row number:" + '\n' + ">");
        row = scanner.nextInt();

        System.out.print("Enter a seat number in that row:" + '\n' + ">");
        seat = scanner.nextInt();

        seatLocation = new SeatLocation(row, seat);
        return seatLocation;
    }
}
