package subway.screen;

import subway.Menu.Menu;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class MainScreen implements ScreenModel {

    private final Scanner scanner;

    public MainScreen(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String showScreen() {
        InputView inputView = new InputView(scanner);

        OutputView.printMainMenu();
        return inputView.enterFeature();
    }

    @Override
    public ScreenModel getNextScreen(String input) {
        if (input.equals(Menu.Main.ROUTE_INQUIRY.getCode())) {
            return new SelectCriteriaScreen(scanner);
        }
        return null;
    }
}
