package museum.exhibition.jsonApi;

import museum.exhibition.domain.exhibitionInfo.Info;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


class OpenApiTest {

    @Autowired
    private OpenApi api;

    @Test
    public void apiTest() throws IOException {

        api.getInfos("1");
    }

    @Test
    public void info(){
    }

}