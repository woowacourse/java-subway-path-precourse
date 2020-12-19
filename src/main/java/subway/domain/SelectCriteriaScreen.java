package subway.domain;

import java.util.Scanner;

public class SelectCriteriaScreen implements ScreenModel {

    private static final String DONE = "-1";
    private final Scanner scanner;

    public SelectCriteriaScreen(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String showMenu() {
        InputView inputView = new InputView(scanner);

        OutputView.printCriteriaMenu();
        String input = inputView.enterFeature();
        if (input.equals(Menu.Main.QUIT)) {
            return DONE;
        }
        return input;
    }

}
