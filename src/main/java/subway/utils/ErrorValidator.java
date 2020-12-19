package subway.utils;

import java.util.InputMismatchException;
import java.util.List;
import subway.domain.StationRepository;

public class ErrorValidator {
    private final static String ERRORMESSAGE = "[ERROR] ";
    private final static String WRONGUSERINPUT = "잘못된 입력입니다.";
    private final static String WRONGSTATIONNAME = "존재하지 않는 역 이름입니다.";
    private final static String SAMESTATIONNAME = "출발역과 도착역이 동일합니다.";

    public static void checkMainSelection(List<String> MAINSELECTLIST, String userSelection){
        if (!MAINSELECTLIST.contains(userSelection)) {
            throw new InputMismatchException(ERRORMESSAGE + WRONGUSERINPUT);
        }
    }

    public static void checkStationRepository(String stationName) {
        if (!StationRepository.checkStation(stationName)) {
            throw new InputMismatchException(ERRORMESSAGE + WRONGSTATIONNAME);
        }
    }

    public static void checkStartEndStation(String startStation, String endStaion) {
        if (startStation.equals(endStaion)) {
            throw new InputMismatchException(ERRORMESSAGE + SAMESTATIONNAME);
        }
    }
}
