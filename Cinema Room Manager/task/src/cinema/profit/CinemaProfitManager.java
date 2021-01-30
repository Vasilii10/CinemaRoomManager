package cinema.profit;

import cinema.RoomDimensions;

public class CinemaProfitManager {

    public static final int PRICE_FOR_FIRST_PART_OF_ROOM = 10;
    public static final int PRICE_FOR_SECOND_PART_OF_ROOM = 8;
    public static final char CURRENCY_SYMBOL = '\u0024';
    private final RoomDimensions roomDimensions;

    public CinemaProfitManager(RoomDimensions roomDimensions) {
        this.roomDimensions = roomDimensions;
    }

    public void printTotalIncomeToConsole() {
        System.out.println("Total income: " + '\n' + CURRENCY_SYMBOL + countTotalIncome());
    }

    private int countTotalIncome() {
        int cinemaCapacity = roomDimensions.getRowLength() * roomDimensions.getSeatsInRow();

        if (cinemaCapacity <= 60) {
            return PRICE_FOR_FIRST_PART_OF_ROOM * cinemaCapacity;
        } else {
            int halfRows = roomDimensions.getRowLength() / 2;
            int seatsInRow = roomDimensions.getSeatsInRow();

            int totalCostOfFirstPart;
            int totalCostOfSecondPart;

            if (roomDimensions.getRowLength() % 2 != 0) {
                totalCostOfFirstPart = seatsInRow * halfRows * PRICE_FOR_FIRST_PART_OF_ROOM;
                totalCostOfSecondPart = (halfRows + 1) * seatsInRow * PRICE_FOR_SECOND_PART_OF_ROOM;
            } else {
                totalCostOfFirstPart = seatsInRow * halfRows * PRICE_FOR_FIRST_PART_OF_ROOM;
                totalCostOfSecondPart = seatsInRow * halfRows * PRICE_FOR_SECOND_PART_OF_ROOM;
            }

            return totalCostOfFirstPart + totalCostOfSecondPart;
        }

    }


}
