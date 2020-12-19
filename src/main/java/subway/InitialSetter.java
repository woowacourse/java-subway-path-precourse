package subway;

import subway.domain.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InitialSetter {
    private static final List<String> STATION_NAME_LIST = Collections.unmodifiableList(
            Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "매봉역"));
    private static final List<String> LINE_NAME_LIST =
            Collections.unmodifiableList(Arrays.asList("2호선", "3호선", "신분당선"));
    private static final List<List<String>> PATH_STATION_LIST = Arrays.asList(
            Arrays.asList("교대역", "강남역", "역삼역"),
            Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역"),
            Arrays.asList("강남역", "양재역", "양재시민숲역")
    );
    private static final List<List<Integer>> PATH_DISTANCE_LIST = Arrays.asList(
            Arrays.asList(2, 2),
            Arrays.asList(3, 6, 1),
            Arrays.asList(2, 10)
    );
    private static final List<List<Integer>> PATH_TIME_LIST = Arrays.asList(
            Arrays.asList(3, 3),
            Arrays.asList(2, 5, 1),
            Arrays.asList(8, 3)
    );
    private static final int ADD_COUNT = 3;


    private InitialSetter() {
    }

    public static void setupInitialInfo() {
        setupStation();
        setupLine();
        setUpPath();
    }

    private static void setupStation() {
        for (String stationName : STATION_NAME_LIST) {
            Station station = new Station(stationName);
            StationRepository.addStation(station);
        }
    }

    private static void setupLine() {
        for (String lineName : LINE_NAME_LIST) {
            Line line = new Line(lineName);
            LineRepository.addLine(line);
        }
    }

    private static void setUpPath() {
        for (int i = 0; i < ADD_COUNT; i++) {
            Path path = new Path(
                    LineRepository.selectLineByName(LINE_NAME_LIST.get(i)),
                    StationRepository.selectStationListByNames(PATH_STATION_LIST.get(i)),
                    PATH_DISTANCE_LIST.get(i),
                    PATH_TIME_LIST.get(i)
            );
            PathRepository.addPath(path);
        }
    }


}
