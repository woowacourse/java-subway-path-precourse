package subway.view;

import java.util.List;

import subway.domain.Station;
import subway.screen.Screen;

public class Output {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String RESULT_PREFIX = "[INFO] ";
    private static final String DIVIDING_LINE = "---";
    
    public static void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }
	
    public static void printResult(String message) {
        System.out.println(RESULT_PREFIX + message);
    }
    
    public static void printMenu(Screen screen) {
        screen.printScreen();
    }
    
    public static void printRoute(List<Station> route) {
        for (Station station : route) {
            printResult(station.getName());
        }
    }
}
