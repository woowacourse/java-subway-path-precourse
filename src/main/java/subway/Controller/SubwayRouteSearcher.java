package subway.Controller;

import java.util.Scanner;
import subway.Views.MainView;

public class SubwayRouteSearcher {

    public static void startProgram(Scanner scanner) {
        Initializer.initializeBaseSetting();
        MainView.printMainScreen(scanner);
    }

    public static void selectMain(Scanner scanner, String userMainSelection) {
        if (userMainSelection.equals("1")) {
            MainView.printRouteScreen(scanner);
        }
    }

    public static void selectRoute(Scanner scanner, String userRouteSelection) {
        if (userRouteSelection.equals("1")) {
            MinDistanceCalculator.calculateMinDistance(scanner);
        }
        if (userRouteSelection.equals("2")) {
            MinTimeCalculator.calculateMinTimeDistance(scanner);
        }
        MainView.printMainScreen(scanner);
    }
}