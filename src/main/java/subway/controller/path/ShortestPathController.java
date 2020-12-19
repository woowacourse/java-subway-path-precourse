package subway.controller.path;

import subway.controller.Controller;
import subway.view.InputView;
import subway.view.OutputView;

public class ShortestPathController implements Controller {

    public final InputView inputView;

    public ShortestPathController(InputView inputView) {
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
