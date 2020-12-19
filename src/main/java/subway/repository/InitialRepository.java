package subway.repository;

import subway.domain.Line;
import subway.domain.Section;
import subway.domain.Station;

import java.util.Arrays;

public class InitialRepository {
    private final String[] initialLines = {"2호선", "3호선", "신분당선"};
    private final String[] initialStations = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};

    public static void end() {
        System.exit(0);
    }

    public void initialize() {
        Arrays.stream(initialLines)
                .forEach(line -> LineRepository.addLine(new Line(line)));
        Arrays.stream(initialStations)
                .forEach(station -> StationRepository.addStation(new Station(station)));

        initialSection("2호선", "교대역", "강남역", 2, 3);
        initialSection("2호선", "강남역", "역삼역", 2, 3);

        initialSection("3호선", "교대역", "남부터미널역", 3, 2);
        initialSection("3호선", "남부터미널역", "양재역", 6, 5);
        initialSection("3호선", "양재역", "매봉역", 1, 1);

        initialSection("신분당선", "강남역", "양재역", 2, 8);
        initialSection("신분당선", "양재역", "양재시민의숲역", 10, 3);
    }

    private void initialSection(String line, String stationNameFrom, String stationNameTo, int distance, int time) {
        Section section = new Section(
                StationRepository.searchStation(stationNameFrom),
                StationRepository.searchStation(stationNameTo),
                distance, time);
        LineRepository.searchLine(line).addSection(section);
    }
}
