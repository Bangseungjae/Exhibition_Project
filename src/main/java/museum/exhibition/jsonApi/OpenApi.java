package museum.exhibition.jsonApi;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import museum.exhibition.domain.exhibitionInfo.Info;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Component;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

@Component
public class OpenApi {

    final static String serviceKey = "25c1fd3e-7953-4abe-9293-603eebf722d7";
    String numOfRows = "10"; // 세션당 요청레코드수
    String pageNo = "1"; // 페이지수


    public Info[] getInfos(String page) throws IOException  {
        pageNo = page;
        StringBuilder urlBuilder = new StringBuilder("http://api.kcisa.kr/openapi/service/rest/meta2020/getMCHBspecial"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey); /*서비스키*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(this.numOfRows, "UTF-8")); /*세션당 요청레코드수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(this.pageNo, "UTF-8")); /*페이지수*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // 연결

        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        //conn.setDoOutput(true);

        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
        }

        System.out.println("rd =" + rd);
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());

        JSONObject xmlJSONobj = XML.toJSONObject(sb.toString());
        String xmlJSONObjectString = xmlJSONobj.toString();

        System.out.println("xmlJSONobj = " + xmlJSONobj);
        JSONObject response = (JSONObject)xmlJSONobj.get("response");
        JSONObject body = (JSONObject) response.get("body");
        JSONObject items = (JSONObject) body.get("items");
        JSONArray jsonArray = (JSONArray) items.get("item");

        Info[] info = new Info[jsonArray.length()];
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject json = (JSONObject)jsonArray.get(i);
                info[i] = new Info((Integer) json.get("publisher"), (String) json.get("creator"), (String) json.get("title"),
                        (String) json.get("regDate"), (String) json.get("eventPeriod"), (String) json.get("url"));
            }
        } catch (NullPointerException e) {

        }
        return info;
    }

    public void OpenApi2() throws IOException  {

        URL url = new URL("http://api.kcisa.kr/openapi/service/rest/meta2020/getMCHBspecial");


    }
}
