package subway.domain;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

import static subway.view.OutputView.*;

public class SubwayApp {
    private final InputView inputView;

    public SubwayApp(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    public void run() {
        try {
            printMainMenu();
            inputView.inputMainMenuOption();
            printPathMenu();
            inputView.inputPathMenuOption();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            run();
        }
    }
}
