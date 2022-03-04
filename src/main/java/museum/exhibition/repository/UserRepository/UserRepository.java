package museum.exhibition.repository.UserRepository;

import museum.exhibition.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

    User findByName(String name);

}
