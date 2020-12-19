package subway;

import java.util.Arrays;
import subway.domain.line.domain.Line;
import subway.domain.line.domain.LineRepository;
import subway.domain.station.domain.Station;
import subway.domain.station.domain.StationRepository;

public class DummyData {

    public static void load() {
        Station station1 = Station.from("교대역");
        Station station2 = Station.from("강남역");
        Station station3 = Station.from("역삼역");
        Station station4 = Station.from("남부터미널역");
        Station station5 = Station.from("양재역");
        Station station6 = Station.from("양재시민의숲역");
        Station station7 = Station.from("매봉역");

        StationRepository.saveAll(
            Arrays.asList(station1, station2, station3, station4, station5, station6, station7)
        );

        Line line1 = Line.of("2호선", station1, station2, 2, 3);
        line1.addSection(station3, 2, 3);

        Line line2 = Line.of("3호선", station1, station4, 3, 2);
        line2.addSection(station5, 6, 5);
        line2.addSection(station7, 1, 1);

        Line line3 = Line.of("신분당선", station2, station5, 2, 8);
        line3.addSection(station6, 10, 3);

        LineRepository.saveAll(Arrays.asList(line1, line2, line3));
    }
}
