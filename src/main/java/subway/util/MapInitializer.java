package subway.util;

import subway.domain.*;

public class MapInitializer {

    public MapInitializer() {
        initStations();
        initLines();
        initSections();
        initEdge();
    }

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
            SectionRepository.addSection(section);
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
        for(Section sc : SectionRepository.sections()) {
            addStation(sc, stationName, lineName);
        }
    }

    public void addStation(Section sc, String stationName, String lineName) {
        if(sc.getLine().getName().equals(lineName)) {
            sc.addStation(new Station(stationName));
        }
    }

    public void initEdge() {
        updateEdge("교대역", "강남역",2,3);
        updateEdge("강남역", "역삼역",2,3);
        updateEdge("교대역", "남부터미널역",3,2);
        updateEdge("남부터미널역", "양재역",6,5);
        updateEdge("양재역", "매봉역",1,1);
        updateEdge("강남역", "양재역",2,8);
        updateEdge("양재역", "양재시민의숲역",10,3);
    }

    public void updateEdge(String station1, String station2, int distance, int time) {
        Edge edge = new Edge(station1, station2, distance, time);
        EdgeRepository.addEdge(edge);
    }
}
