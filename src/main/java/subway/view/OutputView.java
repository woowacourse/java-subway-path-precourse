package subway.view;

import subway.domain.FindPathType;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.menu.MainMenu;

import java.util.List;

public class OutputView {
    private static final String REQUEST_SELECT_MSG = "## 원하는 기능을 선택하세요.";
    private static final String DOT_AND_BLANK = ". ";
    private static final String REQUEST_INPUT_START_STATION_MSG = "## 출발역을 입력하세요";
    private static final String REQUEST_INPUT_END_STATION_MSG = "## 도착역을 입력하세요";
    public static final String THREE_DASH = "---";
    private static String MAIN_MENU_HEADER = "## 메인메뉴";
    private static final String CALCUALTE_PATH_MENU_HEADER = "## 경로기준";

    public static void println(String message) {
        System.out.println(message);
    }

    public static void showMainMenu() {
        String header = MAIN_MENU_HEADER + System.lineSeparator();
        List<String> commands = MainMenu.getCommands();
        List<String> titles = MainMenu.getTitles();
        println(convertMenuToStringForConsoleOutput(header, commands, titles));
        printRequestSelectMsg();
    }

    public static void showShortestPathMenu() {
        String header = CALCUALTE_PATH_MENU_HEADER + System.lineSeparator();
        List<String> commands = FindPathType.getCommands();
        List<String> titles = FindPathType.getTitles();
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

    public static void showRequestStartStationInput() {
        println(REQUEST_INPUT_START_STATION_MSG);
    }

    public static void showRequestEndStationInput() {
        println(REQUEST_INPUT_END_STATION_MSG);
    }

    public static void showShortestPathResult(List<Station> stations) {
        println(THREE_DASH);
        println("총 시간 : " + SectionRepository.calculateTakenTime(stations));
        println("총 거리 : " + SectionRepository.calculateTotalDistance(stations));
        println(THREE_DASH);
        for (Station station : stations) {
            println(station.toString());
        }
    }
}
