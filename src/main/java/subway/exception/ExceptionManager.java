package subway.exception;

import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;

public class ExceptionManager {
    public static final String SAME_STATION_ERROR = "[ERROR] 출발역과 도착역이 동일합니다.";
    public static final String STATION_NOT_EXIST = "[ERROR] 존재하지 않는 역입니다.";
    public static final String PATH_NOT_EXIST = "[ERROR] 존재하지 않은 경로입니다.";
    public static final String COMMAND_WRONG = "[ERROR] 옳지 않은 입력입니다.";

    public static void isSameStations(String station1, String station2) {
        if(station1.equals(station2)) {
            throw new IllegalArgumentException(SAME_STATION_ERROR);
        }
    }

    public static void isStationExist(String station) {
        for(Station st : StationRepository.stations()) {
            boolean check = checkIfExist(st, station);
            if(check) {
                return;
            }
        }
        throw new IllegalArgumentException(STATION_NOT_EXIST);
    }

    public static boolean checkIfExist(Station st, String station) {
        if(st.getName().equals(station)) {
            return true;
        }
        return false;
    }

    public static void isPathExist(List<String> path) {
        if(path.equals(null)) {
            throw new IllegalArgumentException(PATH_NOT_EXIST);
        }
    }

    public static void checkMainCommand(String command) {
        if(command.equals("1") || command.equals("Q")) {
            return;
        }
        throw new IllegalArgumentException(COMMAND_WRONG);
    }

    public static void checkPathCommand(String command) {
        if(command.equals("1") || command.equals("2") || command.equals("B")) {
            return;
        }
        throw new IllegalArgumentException(COMMAND_WRONG);
    }

}
