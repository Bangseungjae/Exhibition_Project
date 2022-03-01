package museum.exhibition.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Reservation extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String period;

    @OneToMany(mappedBy = "reservation")
    private List<UserReservationJoin> users;

    @Nullable
    private String memo;

    @Builder
    public Reservation(String title, String period, List<UserReservationJoin> users) {
        this.title = title;
        this.period = period;
        this.users = users;
    }

    @Builder
    public Reservation(String title, String period, List<UserReservationJoin> users, String memo) {
        this.title = title;
        this.period = period;
        this.users = users;
        this.memo = memo;
    }

    public String addMemo(String memo) {
        this.memo = memo;
        return memo;
    }

}
