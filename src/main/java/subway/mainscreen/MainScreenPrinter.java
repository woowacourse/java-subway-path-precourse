package subway.mainscreen;

public class MainScreenPrinter {
    private static final String MAIN_SCREEN =
        "\n## 메인 화면\n"
            + "1. 경로 조회\n"
            + "Q. 종료";

    public static void printMainScreen() {
        System.out.println(MAIN_SCREEN);
    }
}
