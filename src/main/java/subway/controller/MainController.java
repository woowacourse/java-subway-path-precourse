package subway.controller;

import subway.domain.MainMenu;
import subway.views.mainviews.MainInputView;
import subway.views.mainviews.MainOutputView;

import java.util.Scanner;

public class MainController {
    private static final String END_CODE = "Q";
    private static final MainController mainController = new MainController();

    private MainController() {
    }

    public static MainController getInstance() {
        return mainController;
    }

    public void run(Scanner scanner) {
        String selectedOption;
        do {
            selectedOption = mappingMainMenu(scanner);
        } while (!selectedOption.equals(END_CODE));
    }

    private String mappingMainMenu(Scanner scanner) {
        try {
            MainOutputView.printMainMenu();
            String selectedOption = MainInputView.inputMainOption(scanner);
            branchBySelectedOption(selectedOption, scanner);
            return selectedOption;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return mappingMainMenu(scanner);
        }
    }

    private void branchBySelectedOption(String selectedOption, Scanner scanner) {
        if (selectedOption.equals(END_CODE)) {
            return;
        }
        MainMenu.execute(selectedOption, scanner);
    }
}
