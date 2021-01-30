package cinema.profit;

import cinema.RoomDimensions;

public class CinemaManager {

    public static final int PRICE_FOR_FIRST_PART_OF_ROOM = 10;
    public static final int PRICE_FOR_SECOND_PART_OF_ROOM = 8;
    public static final char CURRENCY_SYMBOL = '\u0024';
    public static final int SMALL_ROOM_LIMIT = 60;
    private final RoomDimensions roomDimensions;

    public CinemaManager(RoomDimensions roomDimensions) {
        this.roomDimensions = roomDimensions;
    }

    public void printTotalIncomeToConsole() {
        System.out.println("Total income: " + '\n' + CURRENCY_SYMBOL + countTotalIncome());
    }

    private boolean cinemaRoomHasOnePrice() {
        return (roomDimensions.getRowLength() * roomDimensions.getSeatsInRow()) <= SMALL_ROOM_LIMIT;
    }

    private int countTotalIncome() {
        int cinemaCapacity = roomDimensions.getRowLength() * roomDimensions.getSeatsInRow();

        if (cinemaRoomHasOnePrice()) {
            return PRICE_FOR_FIRST_PART_OF_ROOM * cinemaCapacity;
        } else {
            int halfRows = roomDimensions.getRowLength() / 2;
            int seatsInRow = roomDimensions.getSeatsInRow();

            int totalCostOfFirstPart;
            int totalCostOfSecondPart;

            if (isASimpleHalf()) {
                totalCostOfFirstPart = seatsInRow * halfRows * PRICE_FOR_FIRST_PART_OF_ROOM;
                totalCostOfSecondPart = (halfRows + 1) * seatsInRow * PRICE_FOR_SECOND_PART_OF_ROOM;
            } else {
                totalCostOfFirstPart = seatsInRow * halfRows * PRICE_FOR_FIRST_PART_OF_ROOM;
                totalCostOfSecondPart = seatsInRow * halfRows * PRICE_FOR_SECOND_PART_OF_ROOM;
            }

            return totalCostOfFirstPart + totalCostOfSecondPart;
        }

    }

    private boolean isASimpleHalf() {
        return roomDimensions.getRowLength() % 2 != 0;
    }

    public void printTicketPriceBy(SeatLocation seatLocation) {
        System.out.println("Ticket price: " + CURRENCY_SYMBOL + definePriceBy(seatLocation));
    }

    private int definePriceBy(SeatLocation seatLocation) {
        if (cinemaRoomHasOnePrice()) {
            return PRICE_FOR_FIRST_PART_OF_ROOM;
        } else {

                int halfRows = roomDimensions.getRowLength() / 2;
                if (seatLocation.row <= halfRows){

                    return PRICE_FOR_FIRST_PART_OF_ROOM;

                } else {
                    return PRICE_FOR_SECOND_PART_OF_ROOM;
                }


        }

    }


}
