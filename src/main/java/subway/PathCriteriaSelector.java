package subway;

import java.util.Scanner;

public class PathCriteriaSelector {
    public static void start(String userSelectionInput, Scanner scanner) {
        printAndGetUserSelectionInput(userSelectionInput, scanner);
    }

    private static void printAndGetUserSelectionInput(String userSelectionInput, Scanner scanner) {
        while (true) {
            try {
                PathCriteriaSelectionScreenPrinter.printMenu();
                CommonPrinter.printUserSelectionMessage();
                String userSelection = scanner.nextLine();
            } catch (IllegalArgumentException e) {
                continue;
            }

            return;
        }
    }
}
