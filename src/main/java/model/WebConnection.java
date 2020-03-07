package model;


import exception.JsonParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WebConnection {
    private static final String address = "http://swopenapi.seoul.go.kr/api/subway/41646171696675633639625856576a/json/realtimeStationArrival/0/5/";
    private final HttpURLConnection connection;

    public WebConnection(String stationName) throws Exception {
        String protocol = "GET";
        URL url = new URL(address + stationName);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(protocol);
    }

    public String getData(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            return br.readLine();
        } catch(IOException e){
            throw new RuntimeException("연결에 실패했습니다.");
        }
    }

    public void disconnect(){
        connection.disconnect();
    }

}
