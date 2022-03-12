package museum.exhibition.domain;

import lombok.*;
import museum.exhibition.web.ReservationDto;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "title", "period"})
public class Reservation extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reservation_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1000)
    private String period;

    @Nullable
    private String memo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String url;

    @Builder
    public Reservation(String title, String period) {
        this.title = title;
        this.period = period;
    }

    @Builder
    public Reservation(String title, String period, User user) {
        this.title = title;
        this.period = period;
        this.user = user;
    }

    @Builder
    public Reservation(String title, String period, User user, String memo) {
        this.title = title;
        this.period = period;
        this.user = user;
        this.memo = memo;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public String addMemo(String memo) {
        this.memo = memo;
        return memo;
    }

    @Builder
    public Reservation(ReservationDto reservationDto, User user) {
        this.title = reservationDto.getTitle();
        this.period = reservationDto.getPeriod();
        this.memo = reservationDto.getMemo();
        this.url = reservationDto.getUrl();
        this.user = user;
    }

}
