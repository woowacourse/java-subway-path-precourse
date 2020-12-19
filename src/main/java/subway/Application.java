package subway;

import subway.controller.MenuScanner;
import subway.domain.Menus;
import subway.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        run(inputView);
    }

    private static void run(InputView inputView) {
        MenuScanner menuScanner = new MenuScanner();
        boolean quit = false;
        do {
            String selectedMenu = menuScanner.scanFunctions(inputView);
            quit = Menus.functions.isQuit(selectedMenu);
        } while(!quit);
    }
}
