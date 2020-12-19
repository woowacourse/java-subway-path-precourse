package subway.view;

import java.util.Scanner;

public class RouteInputView {

    private static final String MIN_DISTANCE_MENU = "1";
    private static final String MIN_TIME_MENU = "1";
    private static final String BACK_MENU = "B";
    private static final String INVALID_INPUT = "[ERROR] 선택할 수 없는 기능입니다.";

    public static String getRouteMenuCommand(Scanner scanner) {
        RouteOutputView.printRouteMenu();
        try {
            String routeMenuCommand = scanner.nextLine();
            validateRouteMenuCommand(routeMenuCommand);
            return routeMenuCommand;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return getRouteMenuCommand(scanner);
        }
    }

    private static void validateRouteMenuCommand(String menuCommand) {
        if (!menuCommand.equals(MIN_DISTANCE_MENU) && !menuCommand.equals(MIN_TIME_MENU)
                && !menuCommand.equals(BACK_MENU)) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }
}
