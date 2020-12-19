package subway.view.message;

import java.util.Arrays;
import java.util.List;

public class MenuMessage {

    public static final String MAIN_LABEL = "## 메인 화면";
    public static final String MAIN_SEEK_PATH = "1. 경로 조회";
    public static final String MAIN_QUIT = "Q. 종료";

    public static final String OPTION_LABEL = "## 경로 기준";
    public static final String OPTION_SHORTEST_PATH = "1. 최단 거리";
    public static final String OPTION_QUICKEST_PATH = "2. 최소 시간";
    public static final String OPTION_QUIT = "B. 돌아가기";

    public static final List<String> MAIN_MENU = Arrays.asList(
            MAIN_LABEL,
            MAIN_SEEK_PATH,
            MAIN_QUIT
    );

    public static final List<String> OPTION_MENU = Arrays.asList(
            OPTION_LABEL,
            OPTION_SHORTEST_PATH,
            OPTION_QUICKEST_PATH,
            OPTION_QUIT
    );
}
