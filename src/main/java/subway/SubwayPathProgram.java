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
        CommonPrinter.printUserSelectionMessage();
        String userSelection = scanner.nextLine();
    }
}
