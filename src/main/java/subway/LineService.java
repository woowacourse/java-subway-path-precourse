package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class LineService {

    public static void addLine(String name) {
        Line line = new Line(name);
        LineRepository.addLine(line);
    }

    public static void lineInAddStation(String lineName, String stationName) {
        Line line = LineRepository.getLine(lineName);
        Station station = StationRepository.getStation(stationName);
        line.lineInAddStation(station);
    }
}
