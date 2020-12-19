package subway.domain;

import subway.menu.MainMenu;
import subway.menu.PathMenu;
import subway.util.Initializer;

import static subway.menu.MainMenu.EXIT;
import static subway.menu.MainMenu.findMainMenuByOption;
import static subway.menu.PathMenu.findPathMenuByOption;
import static subway.view.InputView.inputMainMenuOption;
import static subway.view.InputView.inputPathMenuOption;
import static subway.view.OutputView.printMainMenu;
import static subway.view.OutputView.printPathMenu;

public class SubwayApp {

    public SubwayApp() {
        new Initializer().init();
    }

    public void run() {
        try {
            printMainMenu();
            MainMenu selectedMainMenu = findMainMenuByOption(inputMainMenuOption());
            if (selectedMainMenu == EXIT) {
                return;
            }
            printPathMenu();
            PathMenu findPathMenu = findPathMenuByOption(inputPathMenuOption());
            findPathMenu.request();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            run();
        }
    }
}
