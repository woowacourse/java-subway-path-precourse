package subway.controller;

import subway.exception.GoBackException;
import subway.exception.InputException;
import subway.view.InputView;
import subway.view.OutputView;

public class RouteController implements Controller{

    @Override
    public void run() {
        while (true) {
            try {
                chooseFunction();
            } catch (GoBackException e) {
                return;
            } catch (InputException e) {
                OutputView.printError(e);
            }
        }
    }

    private void chooseFunction() {
        RouteFunction.printFunctions();
        RouteFunction.runFunction(InputView.getInputString());
    }
}
