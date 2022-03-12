package museum.exhibition.service;

import museum.exhibition.domain.Reservation;
import museum.exhibition.domain.User;
import museum.exhibition.web.JoinDto;
import museum.exhibition.web.ReservationDto;
import museum.exhibition.web.UserLoginDto;
import museum.exhibition.web.UserWebDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static museum.exhibition.domain.QReservation.reservation;

@SpringBootTest
class ReservationServiceTest {

    @Autowired
    private ReservationService reservationService;

    @Autowired UserService userService;

    @BeforeEach
    public void before() {
        JoinDto joinUser = new JoinDto("tmdwo", "sj1209", "홍길동", "123@naver.com");
        User user = new User(joinUser);
        userService.save(user);
    }


    @Test
    public void 전시회_추가(){

        UserLoginDto userLoginDto = new UserLoginDto("tmdwo", "sj1209");
        User loginUser = userService.findUserByLogin(userLoginDto);

        ReservationDto reservationDto = new ReservationDto("title", "기간", "memo", "www.wwww");



        reservationService.save(reservationDto, loginUser);
        System.out.println("loginUser id = " + loginUser.getId());
        System.out.println("reservations = " + reservationService.findAll());
        UserWebDto userWebDto = userService.findUserWebbyId(loginUser.getId());


        List<ReservationDto> reservations = userWebDto.getReservations();

        System.out.println("reservation = " + reservation);
    }
}