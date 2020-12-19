package subway;

import subway.domain.line.Line;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

import java.util.Arrays;

public class InitialData {

    public static void saveInitialData() {
        Station station1 = new Station("교대역");
        Station station2 = new Station("강남역");
        Station station3 = new Station("역삼역");
        Station station4 = new Station("남부터미널역");
        Station station5 = new Station("양재역");
        Station station6 = new Station("양재시민의숲역");
        Station station7 = new Station("매봉역");

        StationRepository.saveAll(
                Arrays.asList(station1, station2, station3, station4, station5, station6, station7)
        );

        Line line1 = Line.makeList("2호선", station1);
        line1.addRouteInfo("( 2km / 3분 )");
        line1.addStation(station2);
        line1.addRouteInfo("( 2km / 3분 )");
        line1.addStation(station3);

        Line line2 = Line.makeList("3호선", station1);
        line2.addRouteInfo("( 3km / 2분 )");
        line2.addStation(station4);
        line2.addRouteInfo("( 6km / 5분 )");
        line2.addStation(station5);
        line2.addRouteInfo("( 1km / 1분 )");
        line2.addStation(station7);

        Line line3 = Line.makeList("신분당선", station2);
        line3.addRouteInfo("( 2km / 8분 )");
        line3.addStation(station5);
        line3.addRouteInfo("( 10km / 3분 )");
        line3.addStation(station6);
    }
}
