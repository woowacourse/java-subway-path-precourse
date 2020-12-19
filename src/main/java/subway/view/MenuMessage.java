package subway.view;

import java.util.Arrays;
import java.util.List;

public class MenuMessage {

    public static final String MAIN_LABEL = "## 메인 화면";
    public static final String MAIN_SEEK_PATH = "1. 경로 조회";
    public static final String MAIN_QUIT = "Q. 종료";

    public static final List<String> MAIN_MENU = Arrays.asList(
            MAIN_LABEL,
            MAIN_SEEK_PATH,
            MAIN_QUIT
    );
}
