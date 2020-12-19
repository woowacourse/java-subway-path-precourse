package subway;

import subway.controller.Initializer;
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
        Initializer.set();
        MenuScanner menuScanner = new MenuScanner();
        String selectedMenus = menuScanner.scanMenus(inputView);
        boolean quit = Menus.isQuit(selectedMenus);
        while (!quit) {
            Menus.run(selectedMenus);
            selectedMenus = menuScanner.scanMenus(inputView);
            quit = Menus.isQuit(selectedMenus);
        }
    }
}
