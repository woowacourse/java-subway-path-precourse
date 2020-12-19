package subway.view;

import com.sun.org.apache.regexp.internal.RE;
import subway.dto.PathDTO;
import subway.menuSelection.MainMenuSelection;
import subway.menuSelection.PathStandardSelection;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String INFO_PREFIX = "[INFO] ";
    private static final String SHARP_PREFIX = "## ";
    private static final String MAIN_SCREEN = "메인 화면";
    private static final String PATH_STANDARD = "경로 기준";
    private static final String RESULT = "조회 결과";
    private static final String TOTAL_LENGTH = "총 거리";
    private static final String TOTAL_TIME = "총 소요 시간: %.0f분";
    private static final String BAR = "---";

    public static void printErrorMessage(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }

    public static void printMainMenu() {
        System.out.println(SHARP_PREFIX + MAIN_SCREEN);
        for (MainMenuSelection menu : MainMenuSelection.values()) {
            System.out.println(menu);
        }
    }

    public static void printPathStandardSelectionMenu() {
        System.out.println(SHARP_PREFIX + PATH_STANDARD);
        for (PathStandardSelection menu : PathStandardSelection.values()) {
            System.out.println(menu);
        }
    }

    public static void printResult(PathDTO pathDTO) {
        System.out.println(SHARP_PREFIX + RESULT);
        System.out.println(INFO_PREFIX + BAR);
        System.out.print(INFO_PREFIX);
        System.out.printf(TOTAL_TIME, pathDTO.getCost());
        System.out.println();
        System.out.println(INFO_PREFIX + BAR);
        for (String name : pathDTO.getStationsNameList()) {
            System.out.println(INFO_PREFIX + name);
        }
    }
}
