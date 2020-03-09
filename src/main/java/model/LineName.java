package model;

import exception.MissingSubwayNameListException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class LineName {
    private static final List<String> lineList = new ArrayList<>();
    private final String lineName;

    static {
        try {
            String path = "/Users/macbook/Documents/GitHub/java-subway/src/main/resources/lineName";
            BufferedReader br = new BufferedReader(new FileReader(path));
            String temp;
            while ((temp = br.readLine()) != null) {
                lineList.add(temp);
            }
        } catch (IOException ie) {
            throw new MissingSubwayNameListException("지하철 호선 파일이 존재하지 않습니다.");
        }
    }
    public LineName(String lineName) {
        this.lineName = lineName;
    }

    public String getLineName() {
        return lineName;
    }

    public String getEncodedLineName() {
        try {
            return URLEncoder.encode(lineName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("올바르지 않은 인코딩 방식입니다.");
        }
    }
}
