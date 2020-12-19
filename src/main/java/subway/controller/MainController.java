package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class MainController {

    private final InputView inputView;

    public MainController(InputView inputView) {
        this.inputView = inputView;
    }

    private final List<String> buttons = Arrays.asList(
            MainButton.INQUIRY.getSymbol(),
            MainButton.EXIT.getSymbol()
    );

    public void run() {
        OutputView.printMain();
        inputView.getFunctionSelect(buttons);
    }

}
