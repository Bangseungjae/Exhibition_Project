package museum.exhibition.controller;

import lombok.RequiredArgsConstructor;
import museum.exhibition.domain.exhibitionInfo.Info;
import museum.exhibition.jsonApi.OpenApi;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ApiController {
    private final OpenApi api;

    @GetMapping("/study/{page}")
    public Info[] getExhibitionInfo(@PathVariable String page) throws IOException {
        return api.getInfos(page);
    }

}
