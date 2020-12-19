package subway.domain;

import subway.menu.MainMenu;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

import static subway.menu.MainMenu.*;
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
            inputView.inputPathMenuOption();
            String startStationName = inputView.inputStartStation();
            inputView.inputEndStation(startStationName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            run();
        }
    }
}
