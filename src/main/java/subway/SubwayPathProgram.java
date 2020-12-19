package subway;

import java.util.Scanner;

public class SubwayPathProgram {
    public static void start(Scanner scanner) {
        printAndGetInput(scanner);
    }

    private static void printAndGetInput(Scanner scanner) {
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
            // resolveUserSelection(userSelectionInput);
        }
    }
}
