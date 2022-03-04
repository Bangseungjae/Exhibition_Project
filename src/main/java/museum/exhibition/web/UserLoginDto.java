package museum.exhibition.web;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class UserLoginDto {

    @NotEmpty
    private String loginId;

    @NotEmpty
    private String password;

    public UserLoginDto(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }
}
