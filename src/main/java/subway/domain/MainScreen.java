package subway.domain;

import java.util.Scanner;

public class MainScreen implements ScreenModel{

    public MainScreen(Scanner scanner) {
    }

    public MainScreen() {

    }

    @Override
    public void showMenu() {
        OutputView.printMainMenu();
        InputView.enterFeature();
    }
}
