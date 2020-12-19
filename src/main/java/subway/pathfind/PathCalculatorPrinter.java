package subway.pathfind;

public class PathCalculatorPrinter {
    private static final String START_STATION_USER_INPUT_MESSAGE
        = "\n" + "## 출발역을 입력하세요.";
    private static final String END_STATION_USER_INPUT_MESSAGE
        = "\n" + "## 도착역을 입력하세요.";

    public static void printStartStationUserInputMessage() {
        System.out.println(START_STATION_USER_INPUT_MESSAGE);
    }

    public static void printEndStationUserInputMessage() {
        System.out.println(END_STATION_USER_INPUT_MESSAGE);
    }
}
