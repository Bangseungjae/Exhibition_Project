package museum.exhibition.web;

import lombok.Data;
import museum.exhibition.domain.User;

import javax.validation.constraints.NotEmpty;

@Data
public class JoinDto {

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
    }

    public JoinDto(String loginId, String password, String name, String email) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.email = email;
    }
}
