package subway.domain;

import subway.menu.MainMenu;
import subway.util.Initializer;

import static subway.menu.MainMenu.EXIT;
import static subway.menu.MainMenu.findMainMenuByOption;
import static subway.view.InputView.inputMainMenuOption;
import static subway.view.OutputView.printMainMenu;

public class SubwayApp {

    public SubwayApp() {
        new Initializer().init();
    }

    public void run() {
        appStart();
    }

    private void appStart() {
        try {
            printMainMenu();
            MainMenu selectedMainMenu = findMainMenuByOption(inputMainMenuOption());
            if (selectedMainMenu == EXIT) {
                return;
            }
            selectedMainMenu.request();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            run();
        }
    }
}
