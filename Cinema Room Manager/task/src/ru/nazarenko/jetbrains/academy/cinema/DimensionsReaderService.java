package ru.nazarenko.jetbrains.academy.cinema;

import java.util.Scanner;

public class DimensionsReaderService {

    public static RoomDimensions readRoomDimensionsFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows:" + "\n" + ">");
        int row = scanner.nextInt();

        System.out.print("Enter the number of seats in each row:" + "\n" + ">");
        int length = scanner.nextInt();

        return new RoomDimensions(row, length);
    }

}
