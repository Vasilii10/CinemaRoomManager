package cinema;

import cinema.profit.SeatLocation;

public interface SchemePresenter {

   void presentScheme(RoomDimensions roomDimensions);

   void presentBookedSeatOnTheSheme(RoomDimensions roomDimensions, SeatLocation seatLocation);

}
