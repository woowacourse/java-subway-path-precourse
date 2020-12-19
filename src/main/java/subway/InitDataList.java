package subway;

import subway.domain.*;

import java.util.*;

public enum InitDataList {
    LINE_2("2호선",
            new Path(new StationBetween("교대역", "강남역"), 2, 3),
            new Path(new StationBetween("강남역", "역삼역"), 2, 3)
    ),

    LINE_3("3호선",
            new Path(new StationBetween("교대역", "남부터미널역"), 3, 2),
            new Path(new StationBetween("남부터미널역", "양재역"), 6, 5),
            new Path(new StationBetween("양재역", "매봉역"), 1, 1)
    ),

    LINE_NEW("신분당선",
            new Path(new StationBetween("강남역", "양재역"), 2, 8),
            new Path(new StationBetween("양재역", "양재시민의숲역"), 10, 3)
    );

    private static final int FIRST = 0;
    private static final int SECOND = 1;

    private final String lineName;
    private List<Path> paths;

    InitDataList(String lineName, Path... path) {
        this.lineName = lineName;
        this.paths = Arrays.asList(path);
    }

    public static void insertData() {
        insertStation();
        insertLine();
    }

    private static void insertStation() {
        Arrays.stream(values())
                .forEach(value -> insertEachStation(value.paths));
    }

    private static void insertEachStation(List<Path> paths) {
        getStationList(paths)
                .forEach(StationRepository::addStation);
    }

    private static Set<Station> getStationList(List<Path> paths) {
        Set<Station> stations = new HashSet<>();
        paths.forEach(path -> {
            stations.add(path.getStartStation());
            stations.add(path.getEndStation());
        });
        return stations;
    }

    private static void insertLine() {
        Arrays.stream(values())
                .forEach(value -> {
                    Line line = new Line(value.lineName, value.paths.get(FIRST));
                    insertPathToLine(value, line);
                    LineRepository.addLine(line);
                });
    }

    private static void insertPathToLine(InitDataList value, Line line) {
        for (int index = SECOND; index < value.paths.size(); index++) {
            line.addPath(value.paths.get(index));
        }
    }
}
