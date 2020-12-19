package subway.domain;

import java.util.Arrays;
import java.util.List;

public class Constants {
    public static final List<String> STATIONS = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    public static final String LINE_2 = "2호선";
    public static final List<String> LINE_2_STATIONS = Arrays.asList("교대역", "강남역", "역삼역");
    public static final String LINE_3 = "3호선";
    public static final List<String> LINE_3_STATIONS = Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역");
    public static final String LINE_SINBUNDANG = "신분당선";
    public static final List<String> LINE_SINBUNDANG_STATIONS = Arrays.asList("강남역", "양재역", "양재시민의숲역");
    public static final String PATH_DISTANCE = "DISTANCE";
    public static final String PATH_TIME = "TIME";

    public static final int FUNCTION_INPUT_ERROR = 0;
    public static final int NO_SUCH_NAME_ERROR = 1;
    public static final int SAME_NAME_ERROR = 2;

    public static final String FIND_PATH = "1";
    public static final String FINISH_PROGRAM = "Q";
    public static final List<String> MAIN_FUNCTIONS = Arrays.asList(FIND_PATH, FINISH_PROGRAM);
    public static final String MIN_DISTANCE = "1";
    public static final String MIN_TIME = "2";
    public static final String GO_BACK_MENU = "B";
    public static final List<String> SUB_FUNCTIONS = Arrays.asList(MIN_DISTANCE, MIN_TIME, GO_BACK_MENU);
}
