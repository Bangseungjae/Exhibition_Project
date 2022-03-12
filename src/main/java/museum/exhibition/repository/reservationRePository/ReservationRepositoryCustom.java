package museum.exhibition.repository.reservationRePository;

import museum.exhibition.domain.Reservation;
import museum.exhibition.domain.User;

import java.util.List;

public interface ReservationRepositoryCustom {

    List<Reservation> findReservationsByUser(User user);
}
