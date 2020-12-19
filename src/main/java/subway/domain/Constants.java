package subway.domain;

import java.util.Arrays;
import java.util.List;

public class Constants {
    public static final List<String> line2Stations = Arrays.asList("교대역", "강남역", "역삼역");
    public static final List<Integer> line2Distances = Arrays.asList(2, 2);
    public static final List<Integer> line2Times = Arrays.asList(3, 3);
    public static final List<String> line3Stations = Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역");
    public static final List<Integer> line3Distances = Arrays.asList(3, 6, 1);
    public static final List<Integer> line3Times = Arrays.asList(2, 5, 1);
    public static final List<String> lineSinbundangStations = Arrays.asList("강남역", "양재역", "양재시민의숲역");
    public static final List<Integer> lineSinbundangDistances = Arrays.asList(2, 10);
    public static final List<Integer> lineSinbundangTimes = Arrays.asList(8, 3);

    public static final int FUNCTION_INPUT_ERROR = 0;

    public static final String FIND_PATH = "1";
    public static final String FINISH_PROGRAM = "Q";
    public static final List<String> MAIN_FUNCTIONS = Arrays.asList(FIND_PATH, FINISH_PROGRAM);
    public static final String MIN_DISTANCE = "1";
    public static final String MIN_TIME = "2";
    public static final String GO_BACK_MENU = "B";
    public static final List<String> SUB_FUNCTIONS = Arrays.asList(MIN_DISTANCE, MIN_TIME, GO_BACK_MENU);
}
