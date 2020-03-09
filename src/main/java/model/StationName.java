package model;

import exception.MissingSubwayNameListException;
import exception.WrongStationNameException;

import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class StationName {
    private static final List<String> stationList = new ArrayList<>();
    private final String stationName;

    static {
        try {
            String path = "/Users/macbook/Documents/GitHub/java-subway/src/main/resources/stationName";
            BufferedReader br = new BufferedReader(new FileReader(path));
            String temp;
            while ((temp = br.readLine()) != null) {
                stationList.add(temp);
            }
        } catch (IOException ie) {
            throw new MissingSubwayNameListException("지하철 이름 목록 파일이 존재하지 않습니다.");
        }
    }

    public StationName(String stationName) {
        this.stationName = convertToValidName(trimName(stationName));
    }

    private String trimName(String stationName) {
        return stationName.replaceAll(" ", "");
    }

    private String convertToValidName(String stationName) {
        return stationList.stream()
                .filter(name -> name.length() >= stationName.length())
                .filter(name -> name.substring(0, stationName.length()).equals(stationName))
                .findAny()
                .orElseThrow(()->
                        new WrongStationNameException(stationName + "역은 존재하지 않습니다."));
    }

    public String getEncodedStationName() {
        try {
            return URLEncoder.encode(stationName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("올바르지 않은 인코딩 방식입니다.");
        }
    }
}
