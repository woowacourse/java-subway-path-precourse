package subway.view;

public class RouteOutputView {

    private static final String MAIN_MENU = "## 경로 기준\n1. 최단 거리\n2. 최소 시간\nB. 돌아가기\n";
    private static final String CHOOSE_COMMAND_MESSAGE = "## 원하는 기능을 선택하세요.";

    public static void printRouteMenu() {
        System.out.println();
        System.out.println(MAIN_MENU);
        printChooseCommandMessage();
    }

    public static void printChooseCommandMessage() {
        System.out.println(CHOOSE_COMMAND_MESSAGE);
    }
}
