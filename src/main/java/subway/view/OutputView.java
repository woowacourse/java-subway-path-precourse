package subway.view;

import subway.domain.selector.menu.Menu;

public class OutputView {

    private static final String INFORMATION_TAG = "[INFO]";
    private static final String LINE_STATION_SEPARATOR = "---";
    private static final String SCREEN_MESSAGE_START = "\n## ";
    private static final String SCREEN_MESSAGE_END = " 화면";
    private static final String ID_SEPARATOR = ". ";

    public static void printScreen(Menu menu) {
        System.out.println(SCREEN_MESSAGE_START + menu + SCREEN_MESSAGE_END);
        printMenus(menu);
        printItems(menu);
        System.out.println();
    }

    private static void printMenus(Menu menu) {
        for (String key : menu.getMenus().keySet()) {
            System.out.println(key + ID_SEPARATOR + menu.getMenus().get(key));
        }
    }

    private static void printItems(Menu menu) {
        for (String key : menu.getItems().keySet()) {
            System.out.println(key + ID_SEPARATOR + menu.getItems().get(key));
        }
    }

}
