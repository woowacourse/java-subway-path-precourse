package subway.view;

import java.util.Scanner;

public class InputView {
    public static final String SELECT_MENU_MESSAGE = "\n## 원하는 기능을 선택하세요.";
    public static final String ASK_DEPARTURE_STATION_MESSAGE = "\n## 출발역을 입력하세요.";
    public static final String ASK_ARRIVAL_STATION_MESSAGE = "\n## 도착역을 입력하세요.";

    public static Scanner scanner = new Scanner(System.in);

    public static String getMenu() {
        System.out.println(SELECT_MENU_MESSAGE);
        return scanner.nextLine();
    }

    public static String getDepartureStation() {
        System.out.println(ASK_DEPARTURE_STATION_MESSAGE);
        return scanner.nextLine();
    }

    public static String getArrivalStation() {
        System.out.println(ASK_ARRIVAL_STATION_MESSAGE);
        return scanner.nextLine();
    }
}
