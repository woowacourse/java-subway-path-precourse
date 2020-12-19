package subway.util;

import subway.domain.*;

public class MapInitializer {
    public void initStations() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));

    }

    public void initLines() {
        LineRepository.addLine(new Line("2호선"));
        LineRepository.addLine(new Line("3호선"));
        LineRepository.addLine(new Line("신분당선"));
    }

    public void initSections() {
        for(Line line : LineRepository.lines()) {
            Section section = new Section(line);
        }
        updateSection("2호선", "교대역");
        updateSection("2호선", "강남역");
        updateSection("2호선", "역삼역");
        updateSection("3호선", "교대역");
        updateSection("3호선", "남부터미널역");
        updateSection("3호선", "양재역");
        updateSection("3호선", "매봉역");
        updateSection("신분당선", "강남역");
        updateSection("신분당선", "양재역");
        updateSection("신분당선", "양재시민의숲역");
    }

    public void updateSection(String lineName, String stationName) {
        Station station = null;
        Section section = null;

        station = (Station) StationRepository.stations().stream()
                .filter(st -> st.getName().equals(stationName));

        section = (Section) SectionRepository.sections().stream()
                .filter(section1 -> section1.getLine().getName().equals(lineName));
        section.addStation(station);
    }
}
