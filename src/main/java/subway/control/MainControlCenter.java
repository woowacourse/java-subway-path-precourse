package subway.control;

import subway.view.MainView;

import java.util.Scanner;

public class MainControlCenter {

    public static String inputCommand(Scanner scanner) {
        String command = scanner.nextLine();
        System.out.println();
        return command.trim();
    }

    public void startMainControl(Scanner scanner) {
        String view = "";
        while (!view.equalsIgnoreCase("Q")) {
            showMainMenu();
            String command = inputCommand(scanner);
        }
    }

    private void showMainMenu() {
        MainView.printMainMenu();
        MainView.askInputMenu();
    }

}
