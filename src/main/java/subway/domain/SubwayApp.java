package subway.domain;

import subway.menu.MainMenu;
import subway.menu.PathMenu;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

import static subway.menu.MainMenu.*;
import static subway.menu.PathMenu.*;
import static subway.view.OutputView.*;

public class SubwayApp {
    private final InputView inputView;

    public SubwayApp(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    public void run() {
        try {
            printMainMenu();
            MainMenu selectedMainMenu = findMainMenuByOption(inputView.inputMainMenuOption());
            if (selectedMainMenu == EXIT) {
                return;
            }
            printPathMenu();
            PathMenu findPathMenu = findPathMenuByOption(inputView.inputPathMenuOption());
            findPathMenu.request();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            run();
        }
    }
}
