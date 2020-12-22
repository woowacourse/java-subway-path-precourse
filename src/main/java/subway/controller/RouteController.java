package subway.controller;

import subway.menus.RouteMenu;
import subway.views.routeviews.RouteInputView;
import subway.views.routeviews.RouteOutputView;

import java.util.Scanner;

public class RouteController implements Controller{
    private static final String GO_BACK_CODE = "B";
    private static final RouteController ROUTE_CONTROLLER = new RouteController();

    private RouteController() {
    }

    public static RouteController getInstance() {
        return ROUTE_CONTROLLER;
    }

    public String mappingMenu(Scanner scanner) {
        try {
            RouteOutputView.printRouteMenu();
            String selectedOption = RouteInputView.inputRouteOption(scanner);
            branchBySelectedOption(selectedOption, scanner);
            return selectedOption;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return mappingMenu(scanner);
        }
    }

    private void branchBySelectedOption(String selectedOption, Scanner scanner) {
        if (selectedOption.equals(GO_BACK_CODE)) {
            return;
        }
        RouteMenu.execute(selectedOption, scanner);
    }
}
