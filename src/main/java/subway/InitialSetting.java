package subway;

import subway.domain.Line;
import subway.domain.RequiredResources;
import subway.domain.Section;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.SectionRepository;
import subway.repository.StationRepository;

public class InitialSetting {
    private static final String GYODAE = "교대역";
    private static final String GANGNAM = "강남역";
    private static final String YUCKSAM = "역삼역";
    private static final String NAMBUTERMINAL = "남부터미널역";
    private static final String YANGGAE = "양재역";
    private static final String YANGGAEFORREST = "양재시민의숲역";
    private static final String MAEBONG = "매봉역";
    private static final String LINE_TWO = "2호선";
    private static final String LINE_THREE = "3호선";
    private static final String LINE_SINBUNDANG = "신분당선";
    private static final String[] LINE_TWO_STATIONS = {"교대역", "강남역", "역삼역"};
    private static final String[] LINE_THREE_STATIONS = {"교대역", "남부터미널역", "양재역", "매봉역"};
    private static final String[] LINE_SINBUNDANG_STATIONS = {"강남역", "양재역", "양재시민의숲역"};

    public static void settingInitialSubways() {
        StationRepository.deleteAll();
        LineRepository.deleteAll();

        settingInitialStations();

        settingInitialLines(LINE_TWO, LINE_TWO_STATIONS);
        settingInitialLines(LINE_THREE, LINE_THREE_STATIONS);
        settingInitialLines(LINE_SINBUNDANG, LINE_SINBUNDANG_STATIONS);

        settingInitialSection();
    }

    private static void settingInitialStations() {
        StationRepository.addStation(new Station(GYODAE));
        StationRepository.addStation(new Station(GANGNAM));
        StationRepository.addStation(new Station(YUCKSAM));
        StationRepository.addStation(new Station(NAMBUTERMINAL));
        StationRepository.addStation(new Station(YANGGAE));
        StationRepository.addStation(new Station(YANGGAEFORREST));
        StationRepository.addStation(new Station(MAEBONG));
    }

    private static void settingInitialLines(String lineName, String[] stationNames) {
        Line line = new Line(lineName);
        addStationInLine(line, stationNames);
        LineRepository.addLine(line);
    }

    private static void addStationInLine(Line line, String[] stationNames) {
        for (String stationName : stationNames) {
            line.addLineStation(new Station(stationName));
        }
    }

    private static void settingInitialSection() {
        Section section = new Section(new Station(GYODAE), new Station(GANGNAM));
        RequiredResources requiredResources = new RequiredResources(2, 3);
        SectionRepository.addSection(section, requiredResources);
        section = new Section(new Station(GANGNAM), new Station(YUCKSAM));
        requiredResources = new RequiredResources(2, 3);
        SectionRepository.addSection(section, requiredResources);
        section = new Section(new Station(GYODAE), new Station(NAMBUTERMINAL));
        requiredResources = new RequiredResources(3, 2);
        SectionRepository.addSection(section, requiredResources);
        section = new Section(new Station(NAMBUTERMINAL), new Station(YANGGAE));
        requiredResources = new RequiredResources(6, 5);
        SectionRepository.addSection(section, requiredResources);
        section = new Section(new Station(YANGGAE), new Station(MAEBONG));
        requiredResources = new RequiredResources(1, 1);
        SectionRepository.addSection(section, requiredResources);
        section = new Section(new Station(GANGNAM), new Station(YANGGAE));
        requiredResources = new RequiredResources(2, 8);
        SectionRepository.addSection(section, requiredResources);
        section = new Section(new Station(YANGGAE), new Station(YANGGAEFORREST));
        requiredResources = new RequiredResources(10, 3);
        SectionRepository.addSection(section, requiredResources);
    }
}
