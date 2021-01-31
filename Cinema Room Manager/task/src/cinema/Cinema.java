package cinema;


import java.io.IOException;

public class Cinema {
    public static void main(String[] args) {

        try {
            RoomDimensions roomDimensions = DimensionsReader.readRoomDimensionsFromConsole();

            new CinemaCashierService(roomDimensions).startWorkWithCinemaBy();
        } catch (IOException e) {
            System.err.println("Application error!");
        }
    }
}