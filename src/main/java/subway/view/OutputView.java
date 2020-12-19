package subway.view;

import subway.menu.MainMenu;
import subway.menu.RouteMenu;

import java.util.List;

public class OutputView {
    public static void showMainMenu() {
        String header = "\n## 메인 화면\n";
        List<String> commands = MainMenu.getCommands();
        List<String> titles = MainMenu.getTitles();
        System.out.println(generateMenu(header, commands, titles));
        System.out.println("원하는 기능을 선택하세요.");
    }

    public static void showRouteMenu() {
        String header = "\n## 경로 기준\n";
        List<String> commands = RouteMenu.getCommands();
        List<String> titles = RouteMenu.getTitles();
        System.out.println(generateMenu(header, commands, titles));
        System.out.println("원하는 기능을 선택하세요.");
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
}
