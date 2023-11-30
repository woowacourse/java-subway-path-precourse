package subway.constant;

import java.util.List;

public enum PrintOutMessage {
    MAIN("메인 화면"),
    PLZ_INPUT_FUNCTION("원하는 기능을 선택하세요."),
    PLZ_INPUT_PATH_STANDARD("경로 기준"),
    PLZ_INPUT_START_STATION("출발역을 입력하세요."),
    PLZ_INPUT_END_STATION("도착역을 입력하세요."),
    SEARCHING_RESULT("조회 결과"),
    TOTAL_DISTANCE("총 거리: "),
    TOTAL_TIME("총 소요 시간: "),
    KILOMETER("km"),
    MINUTE("분"),
    EMPTY_LINE("\n"),
    DASH("---");

    public final String message;
    private final String decorate = "## ";
    private static String info = "[INFO] ";

    PrintOutMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return decorate + message;
    }

    public static String getDash() {
        return info + DASH.message;
    }

    public static String printTotalDistance(int distance) {
        return info + TOTAL_DISTANCE.message + distance + KILOMETER.message;
    }

    public static String printTotalTime(int time) {
        return info + TOTAL_TIME.message + time + MINUTE.message;
    }

    public static String getRoutes(List<String> routes) {
        StringBuilder sb = new StringBuilder();
        for (String route : routes) {
            sb.append(info).append(route).append("\n");
        }
        return sb.toString();
    }
}
