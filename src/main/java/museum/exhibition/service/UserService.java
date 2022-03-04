package museum.exhibition.service;

import lombok.RequiredArgsConstructor;
import museum.exhibition.domain.User;
import museum.exhibition.repository.UserRepository.UserRepository;
import museum.exhibition.web.JoinDto;
import museum.exhibition.web.UserLoginDto;
import museum.exhibition.web.UserWebDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Long save(JoinDto joinDto) {
        User user = new User(joinDto.getName(), joinDto.getLoginId(), joinDto.getPassword(), joinDto.getEmail());
        Long id = userRepository.save(user).getId();
        return id;
    }

    public Long update(Long id, JoinDto joinDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));
        user.update(joinDto.getPassword(), joinDto.getEmail());
        return user.getId();
    }

    @Transactional(readOnly = true)
    public JoinDto findById(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));
        return new JoinDto(user);
    }

    @Transactional(readOnly = true)
    public UserWebDto findUserWebbyId(Long id) {
        UserWebDto userWebDto = userRepository.findUserWebDto(id);
        return userWebDto;
    }

    public void delete(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));
        userRepository.delete(user);
    }

    public User login(UserLoginDto loginDto) {
        return userRepository.login(loginDto);
    }

}
