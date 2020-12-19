package subway.view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String receiveMenuSelection(String menu) {
        try {
            OutputView.printMenuSelectionGuide();
            String selection = scanner.nextLine();
            MenuSelectionValidator menuSelectionValidator = new MenuSelectionValidator();
            menuSelectionValidator.validateSelection(menu, selection);
            return selection;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return receiveMenuSelection(menu);
        }
    }
}
