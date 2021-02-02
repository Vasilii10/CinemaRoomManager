package ru.nazarenko.jetbrains.academy.cinema;

public enum TicketPrice {


    FIRST_PART_PRICE(10),
    SECOND_PART_PRICE(8);

    private int value;

    TicketPrice(int price) {
        this.value=price;
    }

   public int getIntValue(){
        return value;
   }
}
