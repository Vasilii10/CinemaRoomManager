package cinema;


import java.io.IOException;

public class Cinema {
    public static void main(String[] args) {
        CinemaCashierService cinemaCashierService = new CinemaCashierService();
        try {
            cinemaCashierService.startBuyTicket();
        } catch (IOException e) {
            System.err.println("Ошибка приложения!");
        }
    }
}