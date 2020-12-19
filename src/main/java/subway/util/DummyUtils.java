package subway.util;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Section;
import subway.domain.Station;
import subway.service.LineService;
import subway.service.StationService;

public class DummyUtils {

    public static void makeDummy() {
        Station station1 = new Station("교대역");
        Station station2 = new Station("강남역");
        Station station3 = new Station("역삼역");
        Station station4 = new Station("남부터미널역");
        Station station5 = new Station("양재역");
        Station station6 = new Station("양재시민의숲역");
        Station station7 = new Station("매봉역");

        StationService.addStation("교대역");
        StationService.addStation("강남역");
        StationService.addStation("역삼역");
        StationService.addStation("남부터미널역");
        StationService.addStation("양재역");
        StationService.addStation("양재시민의숲역");
        StationService.addStation("매봉역");

        Line line1 = new Line("2호선");
        Line line2 = new Line("3호선");
        Line line3 = new Line("신분당선");

        LineRepository.addLine(line1);
        LineRepository.addLine(line2);
        LineRepository.addLine(line3);

        Section section1 = new Section(station1, station2, 2, 3);
        Section section2 = new Section(station2, station3, 2, 3);
        Section section3 = new Section(station1, station4, 3, 2);
        Section section4 = new Section(station4, station5, 6, 5);
        Section section5 = new Section(station5, station7, 1, 1);
        Section section6 = new Section(station2, station5, 2, 8);
        Section section7 = new Section(station5, station6, 10, 3);

        LineService.addSectionInLine(line1, section1);
        LineService.addSectionInLine(line1, section2);
        LineService.addSectionInLine(line2, section3);
        LineService.addSectionInLine(line2, section4);
        LineService.addSectionInLine(line2, section5);
        LineService.addSectionInLine(line3, section6);
        LineService.addSectionInLine(line3, section7);
    }
}
