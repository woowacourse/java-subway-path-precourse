package subway.view;

import subway.MainOption;
import subway.path.SearchMethod;

public class OutputView {
    private static final String MAIN_TITLE = "## 메인 화면";
    private static final String PATH_TITLE = "## 경로 기준";
    private static final String DOT = ". ";
    private static final String SELECT_OPTION = "## 원하는 기능을 선택하세요.";
    private static final String ENTER_START_STATION = "## 출발역을 입력하세요.";
    private static final String ENTER_END_STATION = "## 도착역을 입력하세요.";

    public static void showMainOption() {
        System.out.println(MAIN_TITLE);
        for (MainOption option : MainOption.values()) {
            System.out.print(option.getValue() + DOT);
            System.out.println(option.getDescription());
        }
        System.out.println();
    }

    public static void askOptionChoice() {
        System.out.println(SELECT_OPTION);
    }

    public static void showSearchPathMethod() {
        System.out.println(PATH_TITLE);
        for (SearchMethod method : SearchMethod.values()) {
            System.out.print(method.getValue() + DOT);
            System.out.println(method.getDescription());
        }
        System.out.println();
    }

    public static void askStartStationName() {
        System.out.println(ENTER_START_STATION);
    }

    public static void askEndStationName() {
        System.out.println(ENTER_END_STATION);
    }
}
