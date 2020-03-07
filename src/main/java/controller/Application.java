package controller;

import model.ArrivalData;
import model.StationName;
import model.WebConnection;
import view.InputView;

public class Application {
    public static void main(String[] args) throws Exception {
        StationName stationName = new StationName(InputView.stationName());
        WebConnection conn = new WebConnection(stationName.getEncodedStationName());
        ArrivalData data = new ArrivalData(conn.getData());
        data.parsingData();
        conn.disconnect();
    }
}