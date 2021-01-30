package cinema;

public class RoomDimensions {
    private int rowLength;
    private int seatsInRow;

    public RoomDimensions(int rowLength, int seatsInRow) {
        this.rowLength = rowLength;
        this.seatsInRow = seatsInRow;
    }

    public int getRowLength() {
        return rowLength;
    }

    public int getSeatsInRow() {
        return seatsInRow;
    }
}
