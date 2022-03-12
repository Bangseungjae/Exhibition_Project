package museum.exhibition.domain;

import lombok.*;
import museum.exhibition.web.JoinDto;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "users")
@ToString(of = {"id", "name", "email", "reservations"})
public class User extends BaseTimeEntity{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String loginId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();


    @Builder
    public User(String name, String loginId, String password, String email) {
        this.loginId = loginId;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    @Builder
    public User(String name, String password, String email, List<Reservation> reservations) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.reservations = reservations;
    }

    public User(JoinDto joinDto1) {
        this.loginId = joinDto1.getLoginId();
        this.name = joinDto1.getName();
        this.password = joinDto1.getPassword();
        this.email = joinDto1.getEmail();
    }

    public void addReservation(Reservation reservation){
        reservations.add(reservation);
    }

    public Long update(String password, String email){
        this.password = password;
        this.email = email;
        return this.id;
    }


}
