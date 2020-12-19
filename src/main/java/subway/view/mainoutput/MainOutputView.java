package subway.view.mainoutput;

import subway.view.OutputView;

public class MainOutputView extends OutputView {
    private static final String MAIN_CONTROLLER_OPTION = "메인 화면\n1. 경로 조회\nQ. 종료";

    public static void printOption () {
        printOutput(MAIN_CONTROLLER_OPTION);
        printNewLine();
    }
}
