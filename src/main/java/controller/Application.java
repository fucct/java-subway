package controller;

import model.*;
import view.InputView;

public class Application {
    private static final String realTimeArrival =
            "http://swopenapi.seoul.go.kr/api/subway/41646171696675633639625856576a/json/realtimeStationArrival/0/20/";
    private static final String realTimePosition =
            "http://swopenapi.seoul.go.kr/api/subway/41646171696675633639625856576a/json/realtimePosition/0/20/";

    public static void main(String[] args) throws Exception {
        StationName stationName = new StationName(InputView.stationName());
        LineName lineName = new LineName(InputView.lineName());
        WebConnection arrivalConnection = new WebConnection(realTimeArrival, stationName.getEncodedStationName());
        WebConnection positionConnection = new WebConnection(realTimePosition, lineName.getEncodedLineName());
        ArrivalData arrivalData = new ArrivalData(arrivalConnection.getData());
        PositionData positionData = new PositionData(positionConnection.getData());
        arrivalData.parsingData();
        positionData.parsingData();
    }
}