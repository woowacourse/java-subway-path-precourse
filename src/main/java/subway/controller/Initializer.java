package subway.controller;

import subway.controller.Navigator;
import subway.domain.Edge;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.Line;
import subway.domain.LineRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Initializer {
    private static final int NEXT_CONSTANT = 1;
    private static final int ORDER_CONSTANT = 1;

    private static final String station1 = "교대역";
    private static final String station2 = "강남역";
    private static final String station3 = "역삼역";
    private static final String station4 = "남부터미널역";
    private static final String station5 = "양재역";
    private static final String station6 = "양재시민의숲역";
    private static final String station7 = "매봉역";

    private static final String line1 = "2호선";
    private static final String line2 = "3호선";
    private static final String line3 = "신분당선";

    private static final List<String> initStations = Arrays
        .asList(station1, station2, station3, station4, station5, station6, station7);
    private static final List<String> line1Stations = Arrays.asList(station1, station2, station3);
    private static final List<String> line2Stations = Arrays.asList(station1, station4, station5, station7);
    private static final List<String> line3Stations = Arrays.asList(station2, station5, station6);

    private static final HashMap<String, List<String>> initLines = new HashMap<String, List<String>>() {{
        put(line1, line1Stations);
        put(line2, line2Stations);
        put(line3, line3Stations);
    }};

    private Initializer() {
    }

    public static Navigator set() {
        Navigator navigator = new Navigator();
        HashMap<String,Station> stations = makeStations(navigator);
        List<String> lineNameList = new ArrayList<String>(initLines.keySet());
        for (int i = 0; i < lineNameList.size(); i++) {
            String lineName = lineNameList.get(i);
            makeLine(lineName, navigator);
        }
        return navigator;
    }

    private static HashMap<String, Station> makeStations(Navigator navigator) {
        HashMap<String, Station> stations = new HashMap<String, Station>();
        for (int i = 0; i < initStations.size(); i++) {
            String stationName = initStations.get(i);
            Station station = new Station(stationName);
            StationRepository.addStation(station);
            stations.put(stationName, station);
            navigator.addStation(stationName);
        }
        return stations;
    }

    private static void makeLine(String lineName, Navigator navigator) {
        Line line = new Line(lineName);
        List<String> stationList = initLines.get(lineName);
        for (int i = 0; i < stationList.size(); i++) {
            String stationName = stationList.get(i);
            int order = i + ORDER_CONSTANT;
            line.addStationByName(stationName, order);
            makeEdgeInLine(line, navigator);
        }
        LineRepository.addLine(line);
    }

    private static void makeEdgeInLine(Line line, Navigator navigator) {
        List<Edge> edgeList = makeEdge(line);
        List<String> stationNameList = line.getStationNameList();
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            //line.addEdge(edge,i);
            //navigator.addEdge(stationNameList.get(i), stationNameList.get(i+NEXT_CONSTANT),edge);
        }
    }

    //자료형 사용해보자, 수정 필요
    private static List<Edge> makeEdge(Line line) {
        String lineName = line.getName();
        List<Edge> edgeList = new ArrayList<Edge>();
        if (lineName.equals(line1)) {
            edgeList.add(new Edge(2,3));
            edgeList.add(new Edge(2,3));
        }
        if (lineName.equals(line2)) {
            edgeList.add(new Edge(3,2));
            edgeList.add(new Edge(6,5));
            edgeList.add(new Edge(1,1));
        }
        if (lineName.equals(line3)) {
            edgeList.add(new Edge(2,8));
            edgeList.add(new Edge(10,3));
        }
        return edgeList;
    }
}