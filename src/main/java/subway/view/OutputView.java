package subway.view;

import subway.exception.SubwayException;

public class OutputView {

    public static final String DIVIDER = "---";
    public static final String INFO_PREFIX = "[INFO] ";
    public static final String MENU_PREFIX = "## ";
    public static final String MAIN_SCREEN_MESSAGE = "메인 화면";
    public static final String PATH_SCREEN_MESSAGE = "경로 기준";
    public static final String RESULT_MESSAGE = "조회 결과";
    public static final String CHOOSE_CATEGORY_MESSAGE = "원하는 기능을 선택하세요.";
    public static final String INPUT_START_MESSAGE = "출발역을 입력하세요.";
    public static final String INPUT_END_MESSAGE = "도착역을 입력하세요.";
    public static final String TOTAL_DISTANCE = "총 거리: ";
    public static final String TOTAL_TIME = "총 소요 시간: ";
    public static final String KILOMETER = "km";
    public static final String MINUTE = "분";

    public static void printMainScreen() {
        showMenuMessage(MAIN_SCREEN_MESSAGE);
    }

    public static void chooseCategory() {
        showMenuMessage(CHOOSE_CATEGORY_MESSAGE);
    }

    public static void showErrorMessage(SubwayException exception) {
        System.out.println(exception.getMessage());
    }

    public static void printStartStation() {
        showMenuMessage(INPUT_START_MESSAGE);
    }

    public static void printEndStation() {
        showMenuMessage(INPUT_END_MESSAGE);
    }

    public static void printResult(int distance, int time) {
        showMenuMessage(RESULT_MESSAGE);
        showInfoMessage(DIVIDER);
        showInfoMessage(TOTAL_DISTANCE + distance + KILOMETER);
        showInfoMessage(TOTAL_TIME + time + MINUTE);
        showInfoMessage(DIVIDER);
    }

    public static void printPathScreen() {
        showMenuMessage(PATH_SCREEN_MESSAGE);
    }

    public static void showInfoMessage(String message) {
        System.out.println(INFO_PREFIX + message);
    }

    public static void showMenuMessage(String message) {
        System.out.println(System.lineSeparator() + MENU_PREFIX + message);
    }

}
