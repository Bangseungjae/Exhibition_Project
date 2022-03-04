package museum.exhibition.repository;

import museum.exhibition.domain.Reservation;
import museum.exhibition.domain.User;
import museum.exhibition.repository.UserRepository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
//@Rollback(value = false)
class UserRepositoryTest {

    @Autowired
    EntityManager em;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ReservationRepository reservationRepository;

    //@AfterEach
    public void after() {
        userRepository.deleteAll();
        reservationRepository.deleteAll();
    }

    @Test
    public void test(){

    }

    @Test
    public void saveTest(){
        User user1 = new User("Kim", "asdf", "sj1209", "tmdwo5825@naver.com");
        User user2 = new User("Park", "lkj", "asdf1234", "tmdwo1209@naver.com");

        userRepository.save(user1);
        userRepository.save(user2);

       User testUser = userRepository.findById(1L).get();
       assertThat(user1.getEmail()).isEqualTo(testUser.getEmail());
    }

    @Test
    public void findExhibitionInfoById() {

        User user1 = new User("Kim", "sdf", "sj1209", "tmdwo5825@naver.com");
        userRepository.save(user1);

        Reservation reservation1 = new Reservation("좋은 전시", "2020-10-11 ~ 2020-11-20", user1);
        Reservation reservation2 = new Reservation("나쁜 전시", "2020-10-11 ~ 2020-10-20", user1);

        reservationRepository.save(reservation1);
        reservationRepository.save(reservation2);

        User kim = userRepository.findByName("Kim");
        System.out.println("kim = " + kim);

        List<Reservation> reservations = userRepository.getReservations(kim);
        System.out.println("reservations = " + reservations);
//        assertThat(all).isEqualTo(reservations);
    }
}