package model;

import exception.JsonParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PositionData implements Data {
    private final String positionData;

    public PositionData(String positionData) {
        this.positionData = positionData;
    }

    public void parsingData() {
        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(positionData);
            JSONArray arr = (JSONArray) jsonObject.get("realtimePositionList");
            JSONObject temp = (JSONObject)arr.get(0);
            System.out.println((String)temp.get("subwayNm"));

            for (int i = 0; i < arr.size(); i++) {
                JSONObject obj = (JSONObject) arr.get(i);
                System.out.println();
                System.out.println(obj.get("statnNm"));
            }
        } catch (ParseException pe) {
            throw new JsonParseException("해당 데이터를 불러올 수 없습니다.");
        } catch (NullPointerException ne){
            System.out.println("엥");
        }
    }
}
