package subway.view;

import subway.menu.MainMenu;

import java.util.List;

public class OutputView {
    public static final String REQUEST_SELECT_MSG = "## 원하는 기능을 선택하세요.";
    public static final String DOT_AND_BLANK = ". ";
    private static String MAIN_MENU_HEADER = "## 메인메뉴";
    public static void println(String message){
        System.out.println(message);
    }

    public static void showMainMenu() {
        String header = MAIN_MENU_HEADER + System.lineSeparator();
        List<String> commands = MainMenu.getCommands();
        List<String> titles = MainMenu.getTitles();
        println(convertMenuToStringForConsoleOutput(header, commands, titles));
        printRequestSelectMsg();
    }

    private static void printRequestSelectMsg() {
        println(REQUEST_SELECT_MSG);
    }

    private static String convertMenuToStringForConsoleOutput(String header, List<String> commands, List<String> titles) {
        StringBuilder menu = new StringBuilder(header);
        for (int i = 0; i < commands.size(); i++) {
            String menuLine = commands.get(i)
                    .concat(DOT_AND_BLANK)
                    .concat(titles.get(i))
                    .concat(System.lineSeparator());
            menu.append(menuLine);
        }
        return menu.toString();
    }
}
