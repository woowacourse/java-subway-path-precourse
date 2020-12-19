package subway.constant;

import subway.domain.Line;
import subway.domain.Path;
import subway.domain.Station;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitialData {

    public static final List<Station> stations = new ArrayList<>(Arrays.asList(
            new Station("교대역"),
            new Station("강남역"),
            new Station("역삼역"),
            new Station("남부터미널역"),
            new Station("양재역"),
            new Station("양재시민의숲역"),
            new Station("매봉역")
    ));

    private static final List<Path> lineTwoPaths = new ArrayList<>(Arrays.asList(
            new Path(new Station("교대역"), new Station("강남역"), 2, 3),
            new Path(new Station("강남역"), new Station("역삼역"), 2, 3)
    ));

    private static final List<Path> lineThreePaths = new ArrayList<>(Arrays.asList(
            new Path(new Station("교대역"), new Station("남부터미널역"), 3, 2),
            new Path(new Station("남부터미널역"), new Station("양재역"), 6, 5),
            new Path(new Station("양재역"), new Station("매봉역"), 1, 1), new Path(new Station("양재역"), new Station("매봉역"), 1, 1)
    ));

    private static final List<Path> lineBundangPaths = new ArrayList<>(Arrays.asList(
            new Path(new Station("강남역"), new Station("양재역"), 2, 8),
            new Path(new Station("양재역"), new Station("양재시민의숲역"), 10, 3)
    ));

    public static final List<List<Path>> linePaths = new ArrayList<>(Arrays.asList(
            lineTwoPaths, lineThreePaths, lineBundangPaths
    ));

    public static final List<Line> lines = new ArrayList<>(Arrays.asList(
            new Line("2호선"),
            new Line("3호선"),
            new Line("신분당선")
    ));


}


