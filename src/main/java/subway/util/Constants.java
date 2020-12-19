package subway.util;

public class Constants {

    public static final String[] INITIAL_LINE_NAMES = {"2호선", "3호선", "신분당선"};
    public static final String[][] INITIAL_STATION_NAMES_IN_LINES = {
        {"교대역", "강남역", "역삼역"},
        {"교대역", "남부터미널역", "양재역", "매봉역"},
        {"강남역", "양재역", "양재시민의숲역"}
    };
    public static final int[][][] INITIAL_GAPS_BETWEEN_STATIONS_OF_SECTIONS = {
        {{2, 3}, {2, 3}},
        {{3, 2}, {6, 5}, {1, 1}},
        {{2, 8}, {10, 3}}
    };

    private Constants() {}
}
