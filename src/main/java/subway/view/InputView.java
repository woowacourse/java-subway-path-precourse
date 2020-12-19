package subway.view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;
    private MenuSelectionValidator inputValidator;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
        this.inputValidator = new MenuSelectionValidator();
    }

    public String receiveMenuSelection(String menu) {
        try {
            OutputView.printMenuSelectionGuide();
            String selection = scanner.nextLine();
            inputValidator.validateMenuSelection(menu, selection);
            return selection;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return receiveMenuSelection(menu);
        }
    }

    public String receiveStartStationName() {
        OutputView.printStartStationGuide();
        return scanner.nextLine();
    }
    
    public String receiveEndStationName() {
        OutputView.printEndStationGuide();
        return scanner.nextLine();
    }
}
