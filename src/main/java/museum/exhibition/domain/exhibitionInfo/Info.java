package museum.exhibition.domain.exhibitionInfo;

import lombok.ToString;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;

@ToString
@RequiredArgsConstructor
@Getter
public class Info {

    private Integer publisher;//발행기관
    private String creator;//주된 책임을 진 개체
    private String title;//자원의 명칭
    private String regDate; //등록일
    private String eventPeriod; //실행시기 (기존 = period(기간) + ' ' + time(시간))
    @Nullable
    private String url; //지식정보지원위치정보

    public Info(Integer publisher, String creator, String title, String regDate, String eventPeriod, @Nullable String url) {
        this.publisher = publisher;
        this.creator = creator;
        this.title = title;
        this.regDate = regDate;
        this.eventPeriod = eventPeriod;
        this.url = url;
    }
}