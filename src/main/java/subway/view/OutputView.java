package subway.view;

import static subway.view.message.InfoMessage.*;

import java.util.List;
import subway.domain.graph.DistanceGraphRepository;
import subway.domain.graph.TimeGraphRepository;
import subway.view.message.MenuMessage;

public class OutputView {

    public static void printMainMenu() {
        printMenu(MenuMessage.MAIN_MENU);
    }

    public static void printOptionMenu() {
        printMenu(MenuMessage.OPTION_MENU);
    }

    private static void printMenu(List<String> menuOptions) {
        System.out.println();
        menuOptions.forEach(System.out::println);
    }

    public static void printResult(List<String> chosenPath) {
        System.out.println();
        System.out.println(RESULT_LABEL);
        System.out.println(INFO_LABEL + DIVIDER);
        System.out.printf(TOTAL_DISTANCE, DistanceGraphRepository.totalDistance(chosenPath));
        System.out.printf(TOTAL_TIME, TimeGraphRepository.totalTime(chosenPath));
        System.out.println(INFO_LABEL + DIVIDER);
        chosenPath.forEach(
                station -> System.out.println(INFO_LABEL + station)
        );
    }

    public static void printError(Exception e) {
        System.out.println();
        System.out.println(e.getMessage());
    }
}
