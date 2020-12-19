package subway.view;

public class OutputView {

    private static final String MAIN_SCREEN = "\n## 메인 화면\n1. 경로 조회\nQ. 종료";
    private static final String SUB_SCREEN = "\n## 경로 기준\n1. 최단 거리\n2. 최소 시간\nB. 돌아가기";

    public static void printMainScreen() {
        System.out.println(MAIN_SCREEN);
    }

    public static void printSubScreen() {
        System.out.println(SUB_SCREEN);
    }
}
