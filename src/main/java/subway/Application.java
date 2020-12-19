package subway;

import subway.domain.*;
import subway.view.*;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Init.initialize();
        startProgram(scanner);
    }

    public static void startProgram(Scanner kbd) {
        View.showMainMenu();
        String mainInput = InputView.inputFunction(kbd, Constants.MAIN_FUNCTIONS);
        goSubMenu(mainInput, kbd);
    }

    public static void goSubMenu(String input, Scanner kbd) {
        System.out.println();
        if (input.equals(Constants.FIND_PATH))
            PathManage.managePath(kbd);
        if (input.equalsIgnoreCase(Constants.FINISH_PROGRAM))
            View.finishProgram();
    }
}
