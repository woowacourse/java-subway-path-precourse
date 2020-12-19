package subway.view;

import subway.exception.ExceptionManager;
import subway.util.GraphInitializer;

import java.util.Scanner;

public class Input {
    public static final String ASK_COMMAND = "## 원하는 기능을 선택하세요.";

    public static String getCommand(Scanner scanner) {
        System.out.println(ASK_COMMAND);
        return scanner.nextLine().trim();
    }

    public static String getSourceStation(Scanner scanner) {
        System.out.println(GraphInitializer.ASK_SOURCE);
        String station = scanner.nextLine().trim();
        try {
            ExceptionManager.isStationExist(station);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            FindPathView.printFindPathView(scanner);
        }
        return station;
    }

    public static String getDestinationStation(Scanner scanner) {
        System.out.println(GraphInitializer.ASK_DESTINATION);
        String station = scanner.nextLine().trim();
        return station;
    }
}
