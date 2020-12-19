package subway.controller.path;

import subway.controller.Controller;
import subway.view.InputView;
import subway.view.OutputView;

public class QuickestPathController implements Controller {

    private final InputView inputView;

    public QuickestPathController(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public void run() {
        try {
            getStartingStation();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }

    private String getStartingStation() {
        return inputView.inputStartingStationName();
    }
}
