package model;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebConnection {
    private final HttpURLConnection connection;

    public WebConnection(String url, String data) throws Exception {
        String protocol = "GET";
        URL dataUrl = new URL(url + data);
        connection = (HttpURLConnection) dataUrl.openConnection();
        connection.setRequestMethod(protocol);
    }

    public String getData() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException("연결에 실패했습니다.");
        } finally {
            disconnect();
        }
    }

    public void disconnect() {
        connection.disconnect();
    }
}
