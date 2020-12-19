package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;

public class Subway {

    private final List<String> INIT_LINES = List.of("2호선:교대역-강남역-역삼역", "3호선:교대역-남부터미널역-양재역-매봉역", "신분당선:강남역-양재역-양재시민의숲역");
    private final List<String> INIT_WEIGHTS =
            List.of("교대역:남부터미널역=2/3", "강남역:역삼역=2/3", "교대역:남부터미널역=3/2", "남부터미널역:양재역=6/5", "양재역:매봉역=1/1",
                    "강남역:양재역=2/8", "양재역:양재시민의숲역=10/3");


    public Subway() {

        for (String line : INIT_LINES) {
            String[] split = line.split(":");

            String[] stationNames = split[1].split("-");
            saveStations(stationNames);

            String lineName = split[0];
            saveLines(lineName);

        }

    }

    private void saveLines(String lineName) {
        LineRepository.addLine(new Line(lineName));
    }

    private void saveStations(String[] stations) {
        for (String stationName : stations) {
            StationRepository.addStation(new Station(stationName));
        }
    }
}
