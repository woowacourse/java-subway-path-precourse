package subway.view;

import subway.domain.section.SectionsAndDistance;
import subway.domain.section.SectionsAndTime;

public class OutputView {
    private static final String MAIN_MENU = "\n## 메인 화면\n1. 경로 조회\nQ. 종료";
    private static final String STANDARD_MENU = "\n## 경로 기준\n1. 최단 거리\n2 최소 시간\nB. 돌아가기";
    private static final String SELECT_FUNCTION = "\n##원하는 기능을 선택하세요.";
    private static final String INPUT_START_STATION = "\n## 출발역을 입력하세요.";
    private static final String INPUT_END_STATION = "\n## 도착역을 입력하세요.";
    private static final String ERROR_MESSAGE = "[ERROR] %s";
    private static final String INFO_MESSAGE = "[INFO] %s";
    private static final String DOT = "---";
    private static final String FIND_RESULT = "\n## 조회 결과";
    private static final String ALL_TIME = "총 거리: %dkm";
    private static final String ALL_DISTANCE = "총 소요 시간: %d 분";

    public static void selectMainFunction() {
        System.out.println(MAIN_MENU);
    }

    public static void selectFunction() {
        System.out.println(SELECT_FUNCTION);
    }

    public static void errorOutput(String message) {
        System.out.println(String.format(ERROR_MESSAGE, message));
    }

    public static void selectStandardFunction() {
        System.out.println(STANDARD_MENU);
    }

    public static void inputStartStation() {
        System.out.println(INPUT_START_STATION);
    }

    public static void inputEndStation() {
        System.out.println(INPUT_END_STATION);
    }

    public static void findResult(SectionsAndDistance sectionsAndDistance) {
        System.out.println(FIND_RESULT);
        System.out.println(String.format(INFO_MESSAGE, DOT));
        System.out.println(String.format(ALL_DISTANCE, (int)sectionsAndDistance.getDistances()));
        System.out.println(String.format(INFO_MESSAGE, DOT));
        sectionsAndDistance.getSections().stream().forEach(section ->
                System.out.println(String.format(INFO_MESSAGE, section))
        );
    }

    public static void findResult(SectionsAndTime sectionsAndTime) {
        System.out.println(FIND_RESULT);
        System.out.println(String.format(INFO_MESSAGE, DOT));
        System.out.println(String.format(ALL_TIME, (int)sectionsAndTime.getTime()));
        System.out.println(String.format(INFO_MESSAGE, DOT));
        sectionsAndTime.getSections().stream().forEach(section ->
                System.out.println(String.format(INFO_MESSAGE, section))
        );
    }
}


