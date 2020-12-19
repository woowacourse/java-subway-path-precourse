package subway.Views;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import subway.Controller.SubwayRouteSearcher;
import subway.utils.ErrorValidator;

public class MainView {

    private final static List<String> MAINSELECTLIST = Arrays.asList("1", "Q");
    private final static List<String> ROUTESELECTLIST = Arrays.asList("1", "2", "B");

    public static void printMainScreen(Scanner scanner) {
        OutputView.printMainSelection();
        String userMainSelection = InputView.getUserInput(scanner);
        System.out.println();
        checkUserInput(scanner, userMainSelection, MAINSELECTLIST);
        SubwayRouteSearcher.selectMain(scanner, userMainSelection);
    }

    public static void printRouteScreen(Scanner scanner) {
        OutputView.printRouteSelection();
        String userRouteSelection = InputView.getUserInput(scanner);
        System.out.println();
        checkUserInput(scanner, userRouteSelection, ROUTESELECTLIST);
        SubwayRouteSearcher.selectRoute(scanner, userRouteSelection);
    }

    public static void printResultScreen(Scanner scanner, List<String> resultList) {
        OutputView.printResultRoute(resultList);
        System.out.println();
        MainView.printMainScreen(scanner);
    }


    private static void checkUserInput(Scanner scanner, String userSelection,
        List<String> SELECTLIST) {
        try {
            ErrorValidator.checkMainSelection(SELECTLIST, userSelection);
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            System.out.println();
            printMainScreen(scanner);
        }
    }

    public static String printStartStation(Scanner scanner) {
        String startStaion = InputView.getStartStation(scanner);
        System.out.println();
        checkStartStation(scanner, startStaion);
        return startStaion;
    }

    public static String printEndStation(Scanner scanner, String startStation) {
        String endStaion = InputView.getEndStation(scanner);
        System.out.println();
        checkEndStation(scanner, endStaion);
        checkStartEndStation(scanner, startStation, endStaion);
        return endStaion;
    }

    private static void checkStartEndStation(Scanner scanner, String startStation,
        String endStaion) {
        try {
            ErrorValidator.checkStartEndStation(startStation, endStaion);
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            System.out.println();
            printMainScreen(scanner);
        }
    }

    private static void checkStartStation(Scanner scanner, String startStaion) {
        try {
            ErrorValidator.checkStationRepository(startStaion);
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            System.out.println();
            printMainScreen(scanner);
        }
    }

    private static void checkEndStation(Scanner scanner, String endStaion) {
        try {
            ErrorValidator.checkStationRepository(endStaion);
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            System.out.println();
            printMainScreen(scanner);
        }
    }
}
