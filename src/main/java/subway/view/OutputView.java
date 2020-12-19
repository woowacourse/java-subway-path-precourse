package subway.view;

import subway.exception.SubwayCustomException;

public class OutputView {

    private static final String MAIN_SCREEN = "## 메인 화면\n"
        + "1. 경로 조회\n"
        + "Q. 종료\n";

    public static void printMainScreen() {
        System.out.println(MAIN_SCREEN);
    }

    public static void printError(SubwayCustomException e) {
        System.out.println(e.getMessage());
    }
}
