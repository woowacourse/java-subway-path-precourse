package subway;

import java.util.Arrays;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Initializer {

    private Initializer() {
    }

    public static void init() {
        initStations();
        initSectionsAndLines();
    }

    private static void initSectionsAndLines() {
        Line line1 = new Line("2호선");
        line1.addSection(Section.from("교대역", "강남역",2,3));
        line1.addSection(Section.from("강남역", "역삼역",2,3));

        Line line2 = new Line("3호선");
        line2.addSection(Section.from("교대역", "남부터미널역",3,2));
        line2.addSection(Section.from("남부터미널역", "양재역",6,5));
        line2.addSection(Section.from("양재역", "매봉역",1,1));

        Line line3 = new Line("신분당선");
        line2.addSection(Section.from("강남역", "양재역",2,8));
        line2.addSection(Section.from("양재역", "양재시민의숲역",10,3));

        Arrays.asList(line1,line2,line3).forEach(LineRepository::addLine);

        LineRepository.lines()
                .forEach(line -> line.getSections().forEach(SectionRepository::addSection));
    }

    private static void initStations() {
        Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역")
                .forEach(stationName -> StationRepository.addStation(new Station(stationName)));
    }
}
