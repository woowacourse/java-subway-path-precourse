package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.SectionFactory;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.List;

public class SubwayInitializer {

    private static final String SECOND_LINE = "2호선";
    private static final String THIRD_LINE = "3호선";
    private static final String NEW_BOONDANG_LINE = "신분당선";

    public static void setUp() {
        addStations();
        addLines();
        addSections();
    }

    private static void addStations() {
        List<String> stationNames =
                Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");

        for (String stationName : stationNames) {
            StationRepository.addStation(new Station(stationName));
        }
    }

    private static void addLines() {
        List<String> lineNames = Arrays.asList(SECOND_LINE, THIRD_LINE, NEW_BOONDANG_LINE);
        for (String lineName : lineNames) {
            LineRepository.addLine(new Line(lineName));
        }
    }

    private static void addSections() {
        SectionRepository.addSection(LineRepository.findByName(SECOND_LINE), SectionFactory.makeSection(new Station("교대역"), new Station("강남역"), 2, 3));
        SectionRepository.addSection(LineRepository.findByName(SECOND_LINE), SectionFactory.makeSection(new Station("강남역"), new Station("역삼역"), 2, 3));
        SectionRepository.addSection(LineRepository.findByName(THIRD_LINE), SectionFactory.makeSection(new Station("교대역"), new Station("남부터미널역"), 3, 2));
        SectionRepository.addSection(LineRepository.findByName(THIRD_LINE), SectionFactory.makeSection(new Station("남부터미널역"), new Station("양재역"), 6, 5));
        SectionRepository.addSection(LineRepository.findByName(THIRD_LINE), SectionFactory.makeSection(new Station("양재역"), new Station("매봉역"), 1, 1));
        SectionRepository.addSection(LineRepository.findByName(NEW_BOONDANG_LINE), SectionFactory.makeSection(new Station("강남역"), new Station("양재역"), 2, 8));
        SectionRepository.addSection(LineRepository.findByName(NEW_BOONDANG_LINE), SectionFactory.makeSection(new Station("양재역"), new Station("양재시민의숲역"), 10, 3));
    }
}
