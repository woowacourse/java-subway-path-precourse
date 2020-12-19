package subway.View;

import java.util.Scanner;

public class InputView {

    private static final String CHOOSE_FUNCTION_MAIN="## 원하는 기능을 선택하세요.";
    private static final String STATION_START="## 출발역을 입력하세요.";
    private static final String STATION_END="## 도착역을 입력하세요.";

    public String getStationStart(Scanner scanner){
        System.out.println();
        System.out.println(STATION_START);
        return scanner.nextLine();
    }
    public String getStationEnd(Scanner scanner){
        System.out.println();
        System.out.println(STATION_END);
        return scanner.nextLine();
    }
    public String getChooseFunction(Scanner scanner){
        System.out.println();
        System.out.println(CHOOSE_FUNCTION_MAIN);
        return scanner.nextLine();
    }
}
