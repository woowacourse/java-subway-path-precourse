package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

public class OptionMenuController extends MenuController {

    public OptionMenuController(InputView inputView) {
        super(inputView);
    }

    @Override
    protected void printMenu() {
        OutputView.printOptionMenu();
    }
}
