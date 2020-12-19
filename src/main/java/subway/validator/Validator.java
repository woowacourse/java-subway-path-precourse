package subway.validator;

import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class Validator {
    private static final String UNABLE_INPUT = "[ERROR] 선택할 수 없는 기능입니다.";
    private static final String NOT_EXIST_STATION = "[ERROR] 등록되지 않은 역 이름입니다.";
    private static final String START_END_STATION_EQUALS = "[ERROR] 출발역과 도착역이 동일합니다.";
    private static final int MIN_ROUTE_NUMBER = 1;
    private static final int MAX_ROUTE_NUMBER = 2;
    private static final int MIN_MAIN_NUMBER = 1;
    private static final int MAX_MAIN_NUMBER = 1;
    private static final int BACK_NUMBER = 0;
    private static final int QUIT_NUMBER = 0;



    public Validator() {
    }

    public static int isInputRight(String number) {
        int integerNumber;

        if (number.equals("B")) {
            return BACK_NUMBER;
        }

        try {
            integerNumber = Integer.parseInt(number);
            if (!(integerNumber >= MIN_ROUTE_NUMBER && integerNumber <= MAX_ROUTE_NUMBER)) {
                throw new IllegalArgumentException(UNABLE_INPUT);
            }
            return integerNumber;
        } catch (Exception e) {
            throw new IllegalArgumentException(UNABLE_INPUT);
        }
    }

    public static int isMainInputRight(String number) {
        int integerNumber;

        if (number.equals("Q")) {
            return QUIT_NUMBER;
        }

        try {
            integerNumber = Integer.parseInt(number);
            if (!(integerNumber >= MIN_MAIN_NUMBER && integerNumber <= MAX_MAIN_NUMBER)) {
                throw new IllegalArgumentException(UNABLE_INPUT);
            }
            return integerNumber;
        } catch (Exception e) {
            throw new IllegalArgumentException(UNABLE_INPUT);
        }
    }

    public static void isStationExist(String name) {
        if (StationRepository.getStationByName(name) == null) {
            throw new IllegalArgumentException(NOT_EXIST_STATION);
        }
    }

    public static void isStationEquals(String startStation, String endStation) {
        if (startStation.equals(endStation)) {
            throw new IllegalArgumentException(START_END_STATION_EQUALS);
        }
    }
}
