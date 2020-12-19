package subway.view;

import java.util.Scanner;

import subway.screen.RouteCriterionScreen;
import subway.screen.Screen;

public class Input {
    public static Scanner scanner;
    
    public static String chooseFunction() {
        Screen.chooseFunction();
        return scanner.next();
    }
    
    public static String inputDepartureStation() {
        RouteCriterionScreen.askDepartureStation();
        return scanner.next();
    }
    
    public static String inputArrivalStation() {
        RouteCriterionScreen.askArrivalStation();
        return scanner.next();
    }
}
