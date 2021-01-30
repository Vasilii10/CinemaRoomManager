package cinema;


import cinema.profit.CinemaManager;
import cinema.profit.SeatLocation;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        RoomDimensions roomDimensions =  DimensionsReaderClass.readRoomDimensionsFromConsole();

        CinemaManager cinemaManager = new CinemaManager(
                roomDimensions
        );

        ConsoleCinemaPresenter consoleCinemaPresenter = new ConsoleCinemaPresenter();
        System.out.println();
        consoleCinemaPresenter.presentScheme(roomDimensions);
        System.out.println();

        SeatLocation   seatLocation = null;
        {

            int row, seat;
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a row number:" + '\n' + ">");
            row = scanner.nextInt();

            System.out.print("Enter a seat number in that row:" + '\n' + ">");
            seat = scanner.nextInt();

              seatLocation = new SeatLocation(row,seat);

        }
        System.out.println();

// // TODO: 30/01/2021 передавать введенные числа
        cinemaManager.printTicketPriceBy(seatLocation);

        System.out.println();
        consoleCinemaPresenter.presentBookedSeatOnTheSheme(roomDimensions, seatLocation);
    }

}