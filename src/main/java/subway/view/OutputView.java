package subway.view;

public class OutputView {
    private static final String TITLE_PREFIX = "## ";
    private static final String MAIN_SCREEN_TITLE = "메인 화면";

    public static void printMainScreen(String commandTypeInfos) {
        printTitle(MAIN_SCREEN_TITLE);
        System.out.println(commandTypeInfos);
    }

    private static void printTitle(String title) {
        System.out.println(TITLE_PREFIX + title);
    }

    private static void lineFeed() {
        System.out.println();
    }
}
