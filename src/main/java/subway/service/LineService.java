package subway.service;

import subway.domain.entity.Line;
import subway.domain.entity.Section;
import subway.domain.entity.Station;
import subway.domain.entity.Stations;
import subway.domain.repository.LineRepository;

public class LineService {

    private LineService() {
    }

    public static void addLine(String lineName, Stations stations) {
        LineRepository.findByName(lineName)
                .ifPresent(line -> {
                    throw new IllegalArgumentException();
                });
        Line line = new Line(lineName, stations);
        LineRepository.addLine(line);
    }

    public static void addStationAtLine(String lineName, Station station, Section section) {
        Line line = LineRepository.findByName(lineName)
                .orElseThrow(IllegalArgumentException::new);
        line.addStation(station, section);
    }
}
