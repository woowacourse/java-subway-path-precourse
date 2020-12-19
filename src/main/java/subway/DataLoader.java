package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class DataLoader {
    private static final String[] STATION_DATA = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
    private static final String[] LINE_DATA = {"2호선", "3호선", "신분당선"};

    public static void load() {
        List<Station> stations = Arrays.stream(STATION_DATA)
                .map(Station::new)
                .collect(Collectors.toList());
        stations.forEach(StationRepository::addStation);

        LineRepository.addLine(new Line(LINE_DATA[0], new LinkedList<>(Arrays.asList(stations.get(0), stations.get(1), stations.get(2)))));
        LineRepository.addLine(new Line(LINE_DATA[1], new LinkedList<>(Arrays.asList(stations.get(0), stations.get(3), stations.get(4), stations.get(6)))));
        LineRepository.addLine(new Line(LINE_DATA[2], new LinkedList<>(Arrays.asList(stations.get(1), stations.get(4), stations.get(5)))));
    }
}
