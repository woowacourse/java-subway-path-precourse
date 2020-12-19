package subway.view;

public class OutputView {

    private static final String MAIN_SCREEN = "\n## 메인 화면\n1. 경로 조회\nQ. 종료";
    private static final String SUB_SCREEN = "\n## 경로 기준\n1. 최단 거리\n2. 최소 시간\nB. 돌아가기";
    private static final String SELECT_MESSAGE = "\n## 원하는 기능을 선택하세요.";
    private static final String START_STATION_INPUT_MESSAGE = "\n## 출발역을 입력하세요.";
    private static final String END_STATION_INPUT_MESSAGE = "\n## 도착역을 입력하세요.";

    public static void printMainScreen() {
        System.out.println(MAIN_SCREEN);
    }

    public static void printSubScreen() {
        System.out.println(SUB_SCREEN);
    }

    public static void printSelectMessage() {
        System.out.println(SELECT_MESSAGE);
    }

    public static void printStartInputMessage() {
        System.out.println(START_STATION_INPUT_MESSAGE);
    }

    public static void printEndInputMessage() {
        System.out.println(END_STATION_INPUT_MESSAGE);
    }
}
