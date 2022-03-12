package museum.exhibition.web;

import lombok.Data;
import lombok.NoArgsConstructor;
import museum.exhibition.domain.User;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class JoinDto {

    private Long id;

    @NotEmpty
    private String loginId;

    @NotEmpty
    private String password;

    @NotEmpty
    private String name;

    @NotEmpty
    private String email;

    public JoinDto(User user) {
        this.loginId = user.getLoginId();
        this.password = user.getPassword();
        this.name = user.getName();
        this.email = user.getEmail();
        this.id = user.getId();
    }

    public JoinDto(String loginId, String password, String name, String email) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.email = email;
    }
}
