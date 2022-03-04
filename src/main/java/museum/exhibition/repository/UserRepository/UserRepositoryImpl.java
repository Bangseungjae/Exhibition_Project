package museum.exhibition.repository.UserRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import museum.exhibition.domain.Reservation;
import museum.exhibition.domain.User;
import museum.exhibition.web.UserLoginDto;
import museum.exhibition.web.UserWebDto;

import javax.persistence.EntityManager;
import java.util.List;

import static museum.exhibition.domain.QReservation.*;
import static museum.exhibition.domain.QUser.*;

public class UserRepositoryImpl implements UserRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;


    public UserRepositoryImpl(EntityManager em){
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Reservation> getReservations(User user1) {
        return jpaQueryFactory
                .select(reservation)
                .from(reservation)
                .where(reservation.user.eq(user1))
                .fetch();
    }

    @Override
    public User login(UserLoginDto userLoginDto) {

        return jpaQueryFactory.select(user)
                .from(user)
                .where(user.loginId.eq(userLoginDto.getLoginId()).and(user.password.eq(userLoginDto.getPassword())))
                .fetchOne();
    }

    @Override
    public UserWebDto findUserWebDto(Long id) {
        User user1 = jpaQueryFactory
                .select(user)
                .from(user)
                .join(user.reservations, reservation).fetchJoin()
                .where(user.id.eq(id))
                .fetchOne();

        return new UserWebDto(user1.getName(), user1.getReservations());
    }


}
