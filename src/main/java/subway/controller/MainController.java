package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class MainController {

    private final InputView inputView;
    private final PathController pathController;

    public MainController(InputView inputView) {
        this.inputView = inputView;
        pathController = new PathController(inputView);
    }

    private final List<String> buttons = Arrays.asList(
            MainButton.INQUIRY.getSymbol(),
            MainButton.EXIT.getSymbol()
    );

    public void run() {
        OutputView.printMain();
        String selectedButton = inputView.getFunctionSelect(buttons);
        nextProcedure(selectedButton);
    }

    private void nextProcedure(String button) {
        if (button.equals(MainButton.INQUIRY.getSymbol())) {
            pathController.run();
            run();
        }
    }

}
