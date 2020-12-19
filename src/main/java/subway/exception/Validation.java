package subway.exception;

import subway.model.domain.LineRepository;
import subway.model.domain.Station;
import subway.model.domain.Line;
import subway.model.domain.StationRepository;

import java.util.Arrays;
import java.util.List;

public class Validation {
    private final String NULL_STATION = "등록되지 않은 역입니다.";
    private final String NULL_LINE = "등록되지 않은 노선입니다.";
    private final String OPTION_RULE = "올바른 번호를 입력해 주세요.";
    private final String[] OPTION_MAIN = {"1", "Q", "q"};
    private final String[] OPTION_PATH_FINDER = {"1", "2", "B", "b"};
    private final String STATION_DUPLICATE = "출발역과 도착역이 동일합니다.";

    public Station isExistStation(Station name) throws SubwayException {
        List<Station> stations = StationRepository.stations();
        return stations.stream()
                .filter(station -> station.getName().equals(name))
                .findFirst().orElseThrow(() -> new SubwayException(NULL_STATION));
    }

    public Line isExistLine(String name) throws SubwayException {
        List<Line> lines = LineRepository.lines();
        return lines.stream()
                .filter(line -> line.getName().equals(name))
                .findFirst().orElseThrow(() -> new SubwayException(NULL_LINE));
    }

    public void mainOptionValidation(String input) throws SubwayException {
        if (Arrays.stream(OPTION_MAIN).noneMatch(input::equals)) {
            throw new SubwayException(OPTION_RULE);
        }
    }

    public void stationLineOptionValidation(String input) throws SubwayException {
        if (Arrays.stream(OPTION_PATH_FINDER).noneMatch(input::equals)) {
            throw new SubwayException(OPTION_RULE);
        }
    }

    public void isSameStation(Station start, Station arrive) throws SubwayException {
        if (start == arrive) {
            throw new SubwayException(STATION_DUPLICATE);
        }
    }
}
