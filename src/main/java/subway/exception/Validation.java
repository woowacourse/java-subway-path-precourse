package subway.exception;

import subway.model.domain.Station;
import subway.model.domain.StationRepository;

import java.util.Arrays;
import java.util.List;

public class Validation {
    private final String NULL_STATION = "등록되지 않은 역입니다.";
    private final String OPTION_RULE = "올바른 번호를 입력해 주세요.";
    private final String[] OPTION_MAIN = {"1", "Q", "q"};
    private final String[] OPTION_PATH_FINDER = {"1", "2", "B", "b"};
    private final String STATION_DUPLICATE = "출발역과 도착역이 동일합니다.";

    public Station isExistStation(String name) throws SubwayException {
        List<Station> stations = StationRepository.stations();
        return stations.stream()
                .filter(station -> station.getName().equals(name))
                .findFirst().orElseThrow(() -> new SubwayException(NULL_STATION));
    }

    public void mainOptionValidation(String input) throws SubwayException {
        if (Arrays.stream(OPTION_MAIN).noneMatch(input::equals)) {
            throw new SubwayException(OPTION_RULE);
        }
    }

    public void pathFindOptionValidation(String input) throws SubwayException {
        if (Arrays.stream(OPTION_PATH_FINDER).noneMatch(input::equals)) {
            throw new SubwayException(OPTION_RULE);
        }
    }

    public void isSameStation(String start, String arrive) throws SubwayException {
        if (start.equals(arrive)) {
            throw new SubwayException(STATION_DUPLICATE);
        }
    }
}
