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
    private static final String GYODAE_STATION = "교대역";
    private static final String GANGNAM_STATION = "강남역";
    private static final String YEOKSAM_STATION = "역삼역";
    private static final String SOUTH_TERMINAL_STATION = "남부터미널역";
    private static final String YANGJAE_STATION = "양재역";
    private static final String YANGJAE_FOREST_STATION = "양재시민의숲역";
    private static final String MAEBONG_STATION = "매봉역";

    public static void setUp() {
        addStations();
        addLines();
        addSections();
    }

    private static void addStations() {
        List<String> stationNames =
                Arrays.asList(GYODAE_STATION, GANGNAM_STATION, YEOKSAM_STATION, SOUTH_TERMINAL_STATION, YANGJAE_STATION, YANGJAE_FOREST_STATION, MAEBONG_STATION);

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
        SectionRepository.addSection(LineRepository.findByName(SECOND_LINE), SectionFactory.makeSection(new Station(GYODAE_STATION), new Station(GANGNAM_STATION), 2, 3));
        SectionRepository.addSection(LineRepository.findByName(SECOND_LINE), SectionFactory.makeSection(new Station(GANGNAM_STATION), new Station(YEOKSAM_STATION), 2, 3));
        SectionRepository.addSection(LineRepository.findByName(THIRD_LINE), SectionFactory.makeSection(new Station(GYODAE_STATION), new Station(SOUTH_TERMINAL_STATION), 3, 2));
        SectionRepository.addSection(LineRepository.findByName(THIRD_LINE), SectionFactory.makeSection(new Station(SOUTH_TERMINAL_STATION), new Station(YANGJAE_STATION), 6, 5));
        SectionRepository.addSection(LineRepository.findByName(THIRD_LINE), SectionFactory.makeSection(new Station(YANGJAE_STATION), new Station(MAEBONG_STATION), 1, 1));
        SectionRepository.addSection(LineRepository.findByName(NEW_BOONDANG_LINE), SectionFactory.makeSection(new Station(GANGNAM_STATION), new Station(YANGJAE_STATION), 2, 8));
        SectionRepository.addSection(LineRepository.findByName(NEW_BOONDANG_LINE), SectionFactory.makeSection(new Station(YANGJAE_STATION), new Station(YANGJAE_FOREST_STATION), 10, 3));
    }
}
