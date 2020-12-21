package subway.screen;

import subway.Menu.Menu;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.Scanner;

public class SelectCriteriaScreen implements ScreenModel {

    private final Scanner scanner;

    public SelectCriteriaScreen(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String showScreen() {
        InputView inputView = new InputView(scanner);

        OutputView.printCriteriaMenu();
        String input = inputView.enterFeature();
        if (input.equals(Menu.Main.QUIT)) {
            return GO_BACK;
        }
        return input;
    }

    @Override
    public ScreenModel getNextScreen(String input) {
        if (anyMatchToMenu(input)) {
            return new FeatureScreen(scanner, input);
        }
        throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.\n");
    }

    @Override
    public boolean anyMatchToMenu(String input) {
        return Arrays.stream(Menu.ROUTE_CRITERIA.values())
                .anyMatch(menu -> menu.getCode().equals(input));
    }

}
