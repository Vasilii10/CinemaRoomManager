package cinema;


import cinema.profit.CinemaProfitManager;

public class Cinema {

    public static void main(String[] args) {

        CinemaProfitManager cinemaProfitManager = new CinemaProfitManager(
                DimensionsReaderClass.readRoomDimensionsFromConsole()
        );
        cinemaProfitManager.printTotalIncomeToConsole();


    }
}