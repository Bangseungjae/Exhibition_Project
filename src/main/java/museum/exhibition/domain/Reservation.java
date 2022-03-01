package museum.exhibition.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String period;

    @OneToMany(mappedBy = "reservation")
    private List<UserReservationJoin> users;

    @Builder
    public Reservation(String title, String period, List<UserReservationJoin> users) {
        this.title = title;
        this.period = period;
        this.users = users;
    }

}
