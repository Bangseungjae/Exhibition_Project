package museum.exhibition.web;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import museum.exhibition.domain.Reservation;
import org.springframework.lang.Nullable;

@Data
@NoArgsConstructor
public class ReservationDto {

    private Long id;

    private String title;

    private String period;

    private String url;
    @Nullable
    private String memo;

    @Builder
    public ReservationDto(String title, String period, String url, String memo) {
        this.title = title;
        this.period = period;
        this.url = url;
        this.memo = memo;
    }

    @Builder
    public ReservationDto(String title, String period, String url) {
        this.title = title;
        this.period = period;
        this.url = url;
    }

    public ReservationDto(Reservation reservation) {
        this.id = reservation.getId();
        this.title = reservation.getTitle();
        this.period = reservation.getPeriod();
        this.url = reservation.getUrl();
        this.memo = reservation.getMemo();
    }


}
