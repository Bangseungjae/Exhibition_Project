package museum.exhibition.repository.UserRepository;

import museum.exhibition.domain.Reservation;
import museum.exhibition.domain.User;
import museum.exhibition.web.UserLoginDto;
import museum.exhibition.web.UserWebDto;

import java.util.List;

public interface UserRepositoryCustom {
    List<Reservation> getReservations(User user);

    public User login(UserLoginDto userLoginDto);

    public UserWebDto findUserWebDto(Long id);
}
