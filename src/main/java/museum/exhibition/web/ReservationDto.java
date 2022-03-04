package museum.exhibition.web;

import lombok.Builder;
import lombok.Data;
import museum.exhibition.domain.Reservation;
import org.springframework.lang.Nullable;

@Data
public class ReservationDto {

    private String title;

    private String period;

    @Nullable
    private String memo;

    @Builder
    public ReservationDto(String title, String period) {
        this.title = title;
        this.period = period;
    }

    @Builder
    public ReservationDto(String title, String period, String memo) {
        this.title = title;
        this.period = memo;
        this.memo = memo;
    }

    public ReservationDto(Reservation reservation) {
        this.title = reservation.getTitle();
        this.period = reservation.getPeriod();
        this.memo = reservation.getMemo();
    }


}
