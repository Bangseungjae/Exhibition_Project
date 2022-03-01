package museum.exhibition.repository;

import museum.exhibition.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
class UserRepositoryTest {

    @Autowired UserRepository userRepository;

    @Test
    public void saveTest(){
        User user1 = new User("Kim", "sj1209", "tmdwo5825@naver.com");
        User user2 = new User("Park", "asdf1234", "tmdwo1209@naver.com");

        userRepository.save(user1);
        userRepository.save(user2);

        User testUser = userRepository.findById(1L).get();
        Assertions.assertThat(user1.getEmail()).isEqualTo(testUser.getEmail());
    }

}