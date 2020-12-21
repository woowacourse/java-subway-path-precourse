package subway.screen;

import subway.Menu.Menu;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
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
        if (anyMatchToMenu(input)){
            return new SelectCriteriaScreen(scanner);
        }
        throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.\n");
    }

    @Override
    public boolean anyMatchToMenu(String input) {
        return Arrays.stream(Menu.Main.values())
                .anyMatch(menu -> menu.getCode().equals(input));
    }

}
