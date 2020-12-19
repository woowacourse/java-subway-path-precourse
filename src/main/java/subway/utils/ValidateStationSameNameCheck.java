package subway.utils;

public class ValidateStationSameNameCheck {

    public static void validateStationSameNameCheck(String startStationName, String endStationName) {
        if(startStationName.equals(endStationName)) {
            throw new IllegalArgumentException("[ERROR] 출발역과 도착역이 동일합니다. ");
        }
    }
}
