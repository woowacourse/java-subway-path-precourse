package subway.controller;

import subway.exception.InputException;
import subway.exception.SystemExitException;
import subway.view.InputView;
import subway.view.OutputView;

public class MainController implements Controller{

    @Override
    public void run() {
        while (true) {
            try {
                chooseFunction();
            } catch (SystemExitException e) {
                return;
            } catch (InputException e) {
                OutputView.printError(e);
            }
        }
    }

    private void chooseFunction() {
        MainFunction.printFunctions();
        MainFunction.runFunction(InputView.getInputString());
    }
}
