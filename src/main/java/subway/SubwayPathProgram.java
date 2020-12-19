package subway;

import java.util.Scanner;
import subway.common.CommonPrinter;
import subway.common.CommonErrorChecker;
import subway.mainscreen.MainScreenPrinter;
import subway.mainscreen.MainSelectionType;
import subway.pathfind.PathCriteriaSelector;

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
            String userSelectionInput = printMainScreenAndGetUserSelectionInput(scanner);
            try {
                CommonErrorChecker.validateMenuSelectionInput(userSelectionInput,
                    CommonErrorChecker.MAIN_SELECTION_PATTERN);
            } catch (IllegalArgumentException e) {
                continue;
            }
            if (userSelectionInput.equals(MainSelectionType.QUIT.getStrValue())) {
                return MainSelectionType.QUIT;
            }
            PathCriteriaSelector.start(scanner);
            return MainSelectionType.SUCCESS;
        }
    }

    private static String printMainScreenAndGetUserSelectionInput(Scanner scanner) {
        CommonPrinter.printUserSelectionMessage();
        return scanner.nextLine();
    }
}
