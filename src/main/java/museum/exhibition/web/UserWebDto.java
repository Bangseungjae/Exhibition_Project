package museum.exhibition.web;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import museum.exhibition.domain.Reservation;
import museum.exhibition.domain.User;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserWebDto {

    private Long id;

    private String name;

    private List<ReservationDto> reservations = new ArrayList<>();

    @QueryProjection
    public UserWebDto(User user, List<Reservation> reservations) {
        this.id = user.getId();
        this.name = user.getName();
        for (Reservation reservation : reservations) {
            this.reservations.add(new ReservationDto(reservation));
        }
    }
}
