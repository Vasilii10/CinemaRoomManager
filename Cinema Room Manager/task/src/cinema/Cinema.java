package cinema;

public class Cinema {

    public static final int ROWS = 7;
    public static final int SEATS = 8;

    public static void main(String[] args) {
        SchemePresenter schemePresenter = new ConsoleCinemaPresenter();
        schemePresenter.presentScheme(ROWS, SEATS);
    }
}