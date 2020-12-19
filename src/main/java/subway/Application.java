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
        System.out.println(mainInput);
        //goSubMenu(mainInput, kbd);
    }
}
