package subway.control;

import subway.view.MainView;

import java.util.Scanner;

public class MainControlCenter {

    public void startMainControl(Scanner scanner) {
        showMainMenu();
    }

    private void showMainMenu() {
        MainView.printMainMenu();
        MainView.askInputMenu();
    }
}
