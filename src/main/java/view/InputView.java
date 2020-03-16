package view;

import model.StationName;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String stationName() {
        System.out.println("지하철역 이름을 입력해 주세요 : ");
        return scanner.nextLine();
    }

    public static String lineName() {
        System.out.println("호선 이름을 입력해 주세요 : ");
        return scanner.nextLine();
    }

    public static String upOrDown() {
        System.out.println("내선/외선 을 선택해 주세요");
        System.out.println("잠실새내 방면은 0, 잠실나루 방면은 1을 입력해 주세요 : ");
        return scanner.nextLine();
    }
}
