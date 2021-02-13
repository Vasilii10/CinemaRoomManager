package ru.nazarenko.jetbrains.academy.cinema;

import java.util.Scanner;

public class SeatLocation {
    private final int row;
    private final int seat;

    public SeatLocation(int row, int seat) {
        this.row = row;
        this.seat = seat;
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

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }
}
