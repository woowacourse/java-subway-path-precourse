package subway;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class InitialSetup {
    private static final String[] STATIONS =
        {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
    private static final LinkedHashMap<String, List<String>> STATIONS_OF_LINE =
            new LinkedHashMap<String, List<String>>();
    private static final LinkedHashMap<String, List<Integer>> DISTANCES_OF_LINE =
            new LinkedHashMap<String, List<Integer>>();
    private static final LinkedHashMap<String, List<Integer>> TIMES_OF_LINE =
            new LinkedHashMap<String, List<Integer>>();

    static {
        STATIONS_OF_LINE.put("2호선", Arrays.asList("교대역", "강남역", "역삼역"));
        STATIONS_OF_LINE.put("3호선", Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역"));
        STATIONS_OF_LINE.put("신분당선", Arrays.asList("강남역", "양재역", "양재시민의숲역"));
        
        DISTANCES_OF_LINE.put("2호선", Arrays.asList(2, 2));
        DISTANCES_OF_LINE.put("3호선", Arrays.asList(3, 6, 1));
        DISTANCES_OF_LINE.put("신분당선", Arrays.asList(2, 10));
        
        TIMES_OF_LINE.put("2호선", Arrays.asList(3, 3));
        TIMES_OF_LINE.put("3호선", Arrays.asList(2, 5, 1));
        TIMES_OF_LINE.put("신분당선", Arrays.asList(8, 3));
    }
    
    public static void apply() {
        applyStations();
        applyLines();
    }
    
    private static void applyStations() {
        for (String stationName : STATIONS) {
            StationRepository.addStation(new Station(stationName));
        }
    }
    
    private static void applyLines() {
        for (String lineName : STATIONS_OF_LINE.keySet()) {
            Line currentLine = new Line(lineName);
            LineRepository.addLine(currentLine);
            applyStationsOfLine(currentLine, STATIONS_OF_LINE.get(lineName));
        }
    }
    
    private static void applyStationsOfLine(Line line, List<String> stationNames) {
        List<Integer> distances = DISTANCES_OF_LINE.get(line.getName());
        List<Integer> times = TIMES_OF_LINE.get(line.getName());
        for (int index = 0; index < stationNames.size(); index++) {
            Station currentStation = StationRepository.getStationbyName(stationNames.get(index));
            if (index == 0) {
                line.registerFirstStation(currentStation);
                continue;
            }
            line.pushSections(currentStation, distances.get(index - 1), times.get(index - 1));
        }
    }
}
