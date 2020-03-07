package model;

import exception.WrongStationNameException;

import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class StationName {
    private static final List<String> stationList = new ArrayList<>();
    private final String stationName;

    static{
        try {
            String path = "/Users/macbook/Documents/GitHub/spring5fs-master/java-subway/src/main/resources/stationName";
            BufferedReader br = new BufferedReader(new FileReader(path));
            String temp;
            while((temp = br.readLine()) != null){
                stationList.add(temp);
            }
        } catch(IOException ie){

        }
    }

    public StationName(String stationName) {
        validate(stationName);
        this.stationName = stationName;
    }

    private void validate(String stationName) {
        if(stationList.contains(stationName)){
            return;
        }
        throw new WrongStationNameException(stationName+"역은 존재하지 않습니다.");
    }

    public String getEncodedStationName() {
        try {
            return URLEncoder.encode(stationName, "UTF-8");
        } catch(UnsupportedEncodingException e){
            throw new UnsupportedOperationException("올바르지 않은 인코딩 방식입니다.");
        }
    }
}
