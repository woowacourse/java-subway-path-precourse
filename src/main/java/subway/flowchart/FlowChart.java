package subway.flowchart;

import subway.domain.Constant;
import subway.domain.Menu;

import java.util.Scanner;

public class FlowChart {
    public static void flowChart(Scanner scanner) {
        Menu mainPage = new Menu(Constant.MAIN_MENU_TITLE, Constant.mainMenuItemList());
        String mainInput = mainPage.load(scanner);
        while (true) {
            try {
                routeSelect(scanner, mainInput);
                quit(mainInput);
            } catch (IllegalArgumentException e) {
                System.out.printf(e.getMessage() + "%n%n");
            }
        }
    }

    public static void routeSelect(Scanner scanner, String mainInput) {
        Menu routeSelectPage = new Menu(Constant.ROUTE_SELECT_MENU_TITLE, Constant.routeSelectItemList());
        if (mainInput.equals(Constant.ONE)) {
            String routeSelectInput = routeSelectPage.load(scanner);
            minimumDistance(scanner, routeSelectInput);
            minimumTime(scanner, routeSelectInput);
            back(scanner, routeSelectInput);
        }
    }

    public static void minimumDistance(Scanner scanner, String input) {

    }

    public static void minimumTime(Scanner scanner, String input) {

    }

    public static void back(Scanner scanner, String input) {
        if (input.equals(Constant.B)) {
            flowChart(scanner);
        }
    }

    public static void quit(String mainInput) {
        if (mainInput.equals(Constant.Q)) {
            System.exit(0);
        }
    }
}
