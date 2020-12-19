package subway.view;

import subway.Constant;
import subway.domain.data.Station;
import subway.menu.MainMenu;
import subway.menu.PathRuleMenu;

import java.util.List;

public class OutputView {

    public static void printMainView() {
        printHeader();
        System.out.println(Constant.VIEW_MAIN_HEADER);
        for (MainMenu mainMenu : MainMenu.values()) {
            System.out.printf(Constant.VIEW_MENU_FORMAT, mainMenu.getOrder(), mainMenu.getMenuMessage());
        }
    }

    public static void printPathRuleView() {
        printHeader();
        System.out.println(Constant.VIEW_PATH_RULE_HEADER);
        for (PathRuleMenu pathRuleMenu : PathRuleMenu.values()) {
            System.out.printf(Constant.VIEW_MENU_FORMAT, pathRuleMenu.getOrder(), pathRuleMenu.getMenuMessage());
        }
    }

    public static void printAskingStation(Station.POINT point) {
        printHeader();
        if (point.equals(Station.POINT.STARTING)) {
            System.out.println(Constant.VIEW_ASKING_STARTING_STATION);
            return;
        }
        System.out.println(Constant.VIEW_ASKING_ENDING_STATION);
    }


    public static void printError(String errorMessage) {
        System.out.printf(Constant.EXCEPTION_FORMAT, errorMessage);
    }

    public static void printResult(List<String> list, double weight) {
        printHeader();
        System.out.println(Constant.VIEW_RESULT_HEADER);
        System.out.println(Constant.RESULT_DIVIDER);
        System.out.printf(Constant.RESULT_FORMAT, "총 거리: " + (int) weight + "Km");
        System.out.println(Constant.RESULT_DIVIDER);
        for (String name : list) {
            System.out.printf(Constant.RESULT_FORMAT, name);
        }
    }

    private static void printHeader() {
        System.out.print(Constant.VIEW_HEADER);
    }

    public static void printAskingFunction() {
        printHeader();
        System.out.println(Constant.VIEW_ASKING_FUNCTION);
    }
}
