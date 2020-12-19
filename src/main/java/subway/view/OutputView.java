package subway.view;

import subway.menu.MainMenu;
import subway.menu.RouteMenu;

import java.util.List;

public class OutputView {
    private static final String INFO = "\n[INFO] ";
    private static final String KM = "km";
    private static final String MINUTE = "분";
    private static final String THREE_DASH = " ---";
    private static final String TOTAL_DISTANCE = " 총 거리: ";
    private static final String TOTAL_MINUTE = " 총 소요 시간: ";
    private static final String MAIN_SCREEN = "\n## 메인 화면\n";
    private static final String ROUTE_STANDARD = "\n## 경로 기준\n";
    private static final String LOOKUP_RESULT = "\n## 조회 결과";
    private static final String USER_PROMPT_SELECT_CATEGORY = "## 원하는 기능을 선택하세요.";
    private static final String USER_PROMPT_PLEASE_TYPE = "\n ## %s을 입력하세요.";

    public static void showMainMenu() {
        String header = MAIN_SCREEN;
        List<String> commands = MainMenu.getCommands();
        List<String> titles = MainMenu.getTitles();
        System.out.println(generateMenu(header, commands, titles));
        System.out.println(USER_PROMPT_SELECT_CATEGORY);
    }

    public static void showRouteMenu() {
        String header = ROUTE_STANDARD;
        List<String> commands = RouteMenu.getCommands();
        List<String> titles = RouteMenu.getTitles();
        System.out.println(generateMenu(header, commands, titles));
        System.out.println(USER_PROMPT_SELECT_CATEGORY);
    }

    private static String generateMenu(String header, List<String> commands, List<String> titles) {
        StringBuilder menu = new StringBuilder(header);
        for (int i = 0; i < commands.size(); i++) {
            menu.append(commands.get(i))
                    .append(". ")
                    .append(titles.get(i))
                    .append("\n");
        }
        return menu.toString();
    }

    public static void showPrompt(String departOrArriveStation) {
        System.out.println(String.format(USER_PROMPT_PLEASE_TYPE + departOrArriveStation));
    }

    public static void lookUpResult(int distance, int time, List<String> stations) {
        StringBuilder lookUpResult = new StringBuilder(LOOKUP_RESULT);
        lookUpResult.append(INFO + THREE_DASH);
        lookUpResult.append(INFO + TOTAL_DISTANCE + distance + KM);
        lookUpResult.append(INFO + TOTAL_MINUTE + time + MINUTE);
        lookUpResult.append(INFO + THREE_DASH);
        stations.stream()
                .forEach(stationName -> lookUpResult.append(INFO + stationName));
        System.out.println(lookUpResult.toString());
    }
}
