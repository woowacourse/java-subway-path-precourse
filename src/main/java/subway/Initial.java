package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Initial {
    public static void setInitial() {
        List<String> stationNames;
        stationNames = new ArrayList<>(Arrays.asList("교대역", "강남역", "역삼역"));
        addInitialLine("2호선", stationNames);
        stationNames = new ArrayList<>(Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역"));
        addInitialLine("3호선", stationNames);
        stationNames = new ArrayList<>(Arrays.asList("강남역", "양재역", "양재시민의숲역"));
        addInitialLine("신분당선", stationNames);
        addInitialVertex();
        setInitialEdge();
    }

    public static void addInitialLine(String lineName, List<String> stationNames) {
        Line line = new Line(lineName);
        addInitialStations(stationNames);
        for (String name : stationNames) {
            line.addStation(name);
        }
        LineRepository.addLine(line);
    }

    public static void addInitialStations(List<String> stationNames) {
        for (String name : stationNames) {
            if (StationRepository.isExistStationName(name)) {
                Station station = new Station(name);
                StationRepository.addStation(station);
            }
        }
    }

    public static void addInitialVertex() {
        List<Station> stations = StationRepository.stations();
        for (Station station : stations) {
            LineRepository.addVertex(station.getName());
        }
    }

    public static void setInitialEdge() {
        List<String> source =
                Arrays.asList("교대역", "강남역", "교대역", "남부터미널역", "양재역", "강남역", "양재역");
        List<String> target =
                Arrays.asList("강남역", "역삼역", "남부터미널역", "양재역", "매봉역", "양재역", "양재시민의숲역");
        List<Integer> distance =
                Arrays.asList(2, 2, 3, 6, 1, 2, 10);
        List<Integer> time =
                Arrays.asList(3, 3, 2, 5, 1, 8, 3);
        addInitialEdge(source, target, distance, time);
    }

    public static void addInitialEdge(List<String> source, List<String> target, List<Integer> distance, List<Integer> time) {
        for (int i = 0; i < source.size(); i++) {
            LineRepository.addDistance(source.get(i), target.get(i), distance.get(i));
            LineRepository.addTime(source.get(i), target.get(i), time.get(i));
        }
    }
}
