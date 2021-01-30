package cinema;

public class CinemaProfitManager {

    public static final int PRICE_FOR_FIRST_PART_OF_ROOM = 10;
    public static final int PRICE_FOR_SECOND_PART_OF_ROOM = 8;
    private RoomDimensions roomDimensions;

    public CinemaProfitManager(RoomDimensions roomDimensions) {
        this.roomDimensions = roomDimensions;
    }

    public void printTotalIncomeToConsole() {
        System.out.println("Total income: " + '\n' + '\u0024' + countTotalIncome());
    }


    private int countTotalIncome() {

        int cinemaCapacity = roomDimensions.getRowLength() * roomDimensions.getSeatsInRow();

        if (cinemaCapacity <= 60) {
            return 10 * cinemaCapacity;
        } else {


            int halfRows = roomDimensions.getRowLength() / 2;

            if (roomDimensions.getRowLength() % 2 != 0) {

                int priceForFirstPart = ((halfRows) * PRICE_FOR_FIRST_PART_OF_ROOM * roomDimensions.getSeatsInRow());
                int secondPArt = ((halfRows + 1) * roomDimensions.getSeatsInRow() * PRICE_FOR_SECOND_PART_OF_ROOM);


                return priceForFirstPart + secondPArt;

            } else {
                int priceForFirstPart = roomDimensions.getSeatsInRow() * halfRows * PRICE_FOR_FIRST_PART_OF_ROOM;
                int secondPArt = roomDimensions.getSeatsInRow() * halfRows * PRICE_FOR_SECOND_PART_OF_ROOM;


                return priceForFirstPart + secondPArt;
            }

        }

    }


}
