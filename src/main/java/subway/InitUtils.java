package subway;

import java.util.Arrays;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Section;
import subway.domain.SectionRespository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class InitUtils {

    private static final String[] initStations = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역",
        "매봉역"};
    private static final String[] initLines = {"2호선", "3호선", "신분당선"};

    public static void init() {
        Station station0 = new Station(initStations[0]);
        Station station1 = new Station(initStations[1]);
        Station station2 = new Station(initStations[2]);
        Station station3 = new Station(initStations[3]);
        Station station4 = new Station(initStations[4]);
        Station station5 = new Station(initStations[5]);
        Station station6 = new Station(initStations[6]);
        StationRepository.addAll(
            Arrays.asList(station0, station1, station2, station3, station4, station5, station6));

        Line line0 = new Line(initLines[0]);
        Line line1 = new Line(initLines[1]);
        Line line2 = new Line(initLines[2]);

        Section section0 = new Section(station0, station1, 2, 3);
        Section section1 = new Section(station1, station2, 2, 3);
        Section section2 = new Section(station2, null, 0, 0);
        Section section3 = new Section(station0, station3, 3, 2);
        Section section4 = new Section(station3, station4, 6, 5);
        Section section5 = new Section(station4, station6, 1, 1);
        Section section6 = new Section(station6, null, 0, 0);
        Section section7 = new Section(station1, station2, 2, 8);
        Section section8 = new Section(station2, station5, 10, 3);
        Section section9 = new Section(station5, null, 0, 0);

        SectionRespository.addAll(Arrays.asList(
            section0, section1, section2, section3, section4, section5, section6, section7,
            section8, section9
        ));

        line0.addSection(section0);
        line0.addSection(section1);
        line0.addSection(section2);

        line1.addSection(section3);
        line1.addSection(section4);
        line1.addSection(section5);
        line1.addSection(section6);

        line2.addSection(section7);
        line2.addSection(section8);
        line2.addSection(section9);

        LineRepository.addAll(Arrays.asList(line0, line1, line2));
    }
}
