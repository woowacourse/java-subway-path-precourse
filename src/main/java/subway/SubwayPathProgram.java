package subway;

import java.util.Scanner;

public class SubwayPathProgram {
    public static void start(Scanner scanner) {
        Initializer.initialize();
        printAndGetUserSelectionInput(scanner);
    }

    private static void printAndGetUserSelectionInput(Scanner scanner) {
        MainSelectionType type;
        while (true) {
            MainScreenPrinter.printMainScreen();
            type = getUserSelectionInputType(scanner);
            if (type == MainSelectionType.QUIT) {
                return;
            }
        }
    }

    private static MainSelectionType getUserSelectionInputType(Scanner scanner) {
        while (true) {
            CommonPrinter.printUserSelectionMessage();
            String userSelectionInput = scanner.nextLine();
//            try {
//                validateMainUserSelectionInput(userSelectionInput);
//            } catch (IllegalArgumentException e) {
//                continue;
//            }
            if (userSelectionInput.equals(MainSelectionType.QUIT.getStrValue())){
                return MainSelectionType.QUIT;
            }
            PathCriteriaSelector.start(scanner);
            return MainSelectionType.SUCCESS;
        }
    }
}
