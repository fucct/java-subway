package model;

import exception.JsonParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ArrivalData {
    private final String arrivalData;

    public ArrivalData(String arrivalData) {
        this.arrivalData = arrivalData;
    }

    public void parsingData() throws Exception{
        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(arrivalData);
            JSONArray arr = (JSONArray) jsonObject.get("realtimeArrivalList");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date now = new Date();

            for (int i = 0; i < arr.size(); i++) {
                JSONObject obj = (JSONObject) arr.get(i);
                String arrivalDate = (String)obj.get("recptnDt");
                long arrivalTime = format.parse(arrivalDate).getTime();
                long nowTime = now.getTime();
                long leftTime = arrivalTime - nowTime;
                System.out.println("도착 시간 : " + new Date(arrivalTime));
                System.out.println("현재 : " + new Date(nowTime));
                System.out.println("남은 시간 : " + leftTime/1000/60 +"분" + leftTime%1000%60+"초");
                /*String tmp = arrivalDate.split(" ")[1];
                Date arrival = format.parse(tmp);
                String left = format.format(new Date(arrival.getTime() - date.getTime()));
                System.out.println(obj.get("trainLineNm") + " : " + arrivalDate);
                System.out.println(obj.get("trainLineNm") + " : " + left);*/
            }
        } catch (ParseException pe) {
            throw new JsonParseException("해당 데이터를 불러올 수 없습니다.");
        }
    }
}
