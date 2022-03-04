package museum.exhibition.web;

import lombok.Data;
import museum.exhibition.domain.Reservation;

import java.util.List;

@Data
public class UserWebDto {

    private String name;

    private List<Reservation> reservation;

    public UserWebDto(String name, List<Reservation> reservation) {
        this.name = name;
        this.reservation = reservation;
    }
}
