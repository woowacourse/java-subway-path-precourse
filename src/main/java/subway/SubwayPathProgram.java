package subway;

import java.util.Scanner;

public class SubwayPathProgram {
    public static void start(Scanner scanner) {
        printAndGetUserSelectionInput(scanner);
    }

    private static void printAndGetUserSelectionInput(Scanner scanner) {
        MainScreenPrinter.printMainScreen();
        getUserSelectionInput(scanner);
    }

    private static void getUserSelectionInput(Scanner scanner) {
        while (true) {
            CommonPrinter.printUserSelectionMessage();
            String userSelectionInput = scanner.nextLine();
//            try {
//                validateMainUserSelectionInput(userSelectionInput);
//            } catch (IllegalArgumentException e) {
//                continue;
//            }
            if (userSelectionInput.equals(MainSelection.QUIT.getStrValue())){
                return;
            }
            PathCriteriaSelector.start(userSelectionInput, scanner);
        }
    }
}
