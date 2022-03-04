package museum.exhibition.service;

import museum.exhibition.domain.Reservation;
import museum.exhibition.domain.User;
import museum.exhibition.web.JoinDto;
import museum.exhibition.web.ReservationDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void 가입하기(){
        JoinDto joinDto = new JoinDto("asdf", "sj1209", "tmdwo", "tmdwo5825@naver.com");
        Long saveId = userService.save(joinDto);

        JoinDto joinDto1 = userService.findById(saveId);
        Assertions.assertThat(joinDto).isEqualTo(joinDto1);
    }


}