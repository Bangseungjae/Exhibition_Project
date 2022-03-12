package museum.exhibition.repository.reservationRePository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import museum.exhibition.domain.Reservation;
import museum.exhibition.domain.User;

import javax.persistence.EntityManager;
import java.util.List;

import static museum.exhibition.domain.QReservation.*;

public class ReservationRepositoryImpl implements ReservationRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public ReservationRepositoryImpl(EntityManager em) {
        jpaQueryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Reservation> findReservationsByUser(User user) {

        List<Reservation> reservations = jpaQueryFactory
                .select(reservation)
                .from(reservation)
                .where(reservation.user.eq(user))
                .fetch();

        return reservations;
    }
}
