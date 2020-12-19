package subway.domain;


public class ErrorMessage {

    private static final String PREFIX = "[ERROR] ";
    private static final String CANNOT_CHOOSE_FUNCTION = "선택할 수 없는 기능입니다";
    private static final String NOT_EXIST_STATION = "존재하지 않는 역입니다";
    private static final String SAME_STATION = "출발역과 도착역이 동일합니다";
    public static String isNotFunction() {
        return PREFIX + CANNOT_CHOOSE_FUNCTION;
    }

    public static String isNotStation() {
        return PREFIX + NOT_EXIST_STATION;
    }

    public static String isSameStation() {
        return PREFIX + SAME_STATION;
    }
}
