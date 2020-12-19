package subway.view;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import subway.domain.Distance;
import subway.domain.Time;

public class PathFindDisplay extends Display {

    private static final String DISPLAY_NAME = "경로 기준";
    private static final String MENU_DOT = ". ";
    private static final String PATH_FIND_RESULT = "조회 결과";
    private static final String DASH_LINE = "---";
    private static final String TOTAL_DISTANCE = "총 거리: ";
    private static final String KILO_METER = "km";
    private static final String TOTAL_TIME = "총 소요 시간: ";
    private static final String MINUTE = "분";
    private static final String INFO_PREFIX = "[INFO] ";

    public static void loadMenu() {
        PathFindMenu selectedMenu = null;
        while (selectedMenu != PathFindMenu.BACK) {
            printMenu();
            selectedMenu = selectMenu();
            try {
                selectedMenu.execute();
                break;
            } catch (IllegalArgumentException e) {
                printError(e.getMessage());
            }
        }
    }

    private static void printMenu() {
        printNotice(DISPLAY_NAME);
        Arrays.stream(PathFindMenu.values()).forEach(menu ->
            System.out.println(menu.getKey() + MENU_DOT + menu.getName()));
    }

    private static PathFindMenu selectMenu() {
        while (true) {
            try {
                return PathFindMenu.getMenuByInput(UserInput.getSelectMenu());
            } catch (NoSuchElementException e) {
                printMenuSelectError();
            }
        }
    }

    public static void printPathFindResult(Distance distance, Time time, List<String> path) {
        printNotice(PATH_FIND_RESULT);
        System.out.println(INFO_PREFIX + DASH_LINE);
        System.out.println(INFO_PREFIX + TOTAL_DISTANCE + distance.getKilometer() + KILO_METER);
        System.out.println(INFO_PREFIX + TOTAL_TIME + time.getMinute() + MINUTE);
        System.out.println(INFO_PREFIX + DASH_LINE);
        path.stream().forEach(stationName -> System.out.println(INFO_PREFIX + stationName));
    }
}
