package subway.domain;

import java.util.Scanner;

public class MainScreen implements ScreenModel {

    private final Scanner scanner;

    public MainScreen(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String showMenu() {
        InputView inputView = new InputView(scanner);

        OutputView.printMainMenu();
        return inputView.enterFeature();
    }

    @Override
    public ScreenModel getNextMenuScreen(String input) {
        if (input.equals( Menu.Main.ROUTE_INQUIRY.getCode())) {
            return new SelectCriteriaScreen(scanner);
        }
        return null;
    }
}
