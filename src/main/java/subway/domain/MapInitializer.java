package subway.domain;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.path.Path;
import subway.domain.path.PathService;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

import java.util.Arrays;
import java.util.List;

public class MapInitializer {
    private MapInitializer() {
    }

    public static void initialize() {
        Station station1 = new Station("교대역");
        Station station2 = new Station("강남역");
        Station station3 = new Station("역삼역");
        Station station4 = new Station("남부터미널역");
        Station station5 = new Station("양재역");
        Station station6 = new Station("양재시민의숲역");
        Station station7 = new Station("매봉역");

        List<Station> stations = Arrays.asList(station1, station2, station3, station4, station5, station6, station7);
        StationRepository.addAll(stations);

        Line line1 = new Line("2호선", station1, station3);
        line1.insert(1, station2);
        PathService.addPath(new Path(station1, station2, line1, 2, 3));
        PathService.addPath(new Path(station2, station3, line1, 2, 3));

        Line line2 = new Line("3호선", station1, station7);
        line2.insert(1, station5);
        line2.insert(1, station4);
        PathService.addPath(new Path(station1, station4, line2, 3, 2));
        PathService.addPath(new Path(station4, station5, line2, 6, 5));
        PathService.addPath(new Path(station5, station7, line2, 1, 1));

        Line line3 = new Line("신분당선", station2, station6);
        line3.insert(1, station5);
        PathService.addPath(new Path(station2, station5, line3, 2, 8));
        PathService.addPath(new Path(station5, station6, line3, 10, 3));

        List<Line> lines = Arrays.asList(line1, line2, line3);
        LineRepository.addAll(lines);
    }
}
