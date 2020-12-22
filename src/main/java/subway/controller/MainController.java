package subway.controller;

import subway.menus.MainMenu;
import subway.views.mainviews.MainInputView;
import subway.views.mainviews.MainOutputView;

import java.util.Scanner;

public class MainController implements Controller{
    private static final String END_CODE = "Q";
    private static final MainController MAIN_CONTROLLER = new MainController();

    private MainController() {
    }

    public static MainController getInstance() {
        return MAIN_CONTROLLER;
    }

    public void run(Scanner scanner) {
        String selectedOption;
        do {
            selectedOption = mappingMenu(scanner);
        } while (!selectedOption.equals(END_CODE));
    }

    public String mappingMenu(Scanner scanner) {
        try {
            MainOutputView.printMainMenu();
            String selectedOption = MainInputView.inputMainOption(scanner);
            branchBySelectedOption(selectedOption, scanner);
            return selectedOption;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return mappingMenu(scanner);
        }
    }

    private void branchBySelectedOption(String selectedOption, Scanner scanner) {
        if (selectedOption.equals(END_CODE)) {
            return;
        }
        MainMenu.execute(selectedOption, scanner);
    }
}
