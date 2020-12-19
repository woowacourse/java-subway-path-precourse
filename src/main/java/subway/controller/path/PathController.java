package subway.controller.path;

import subway.controller.Controller;
import subway.view.InputView;
import subway.view.OutputView;

public abstract class PathController implements Controller {

    public final InputView inputView;

    public PathController(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public void run() {
        try {
            getStartingStation();
            getFinishingStation();

            calculatePath();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }

    protected abstract void calculatePath();

    protected String getStartingStation() {
        return inputView.inputStartingStationName();
    }

    protected String getFinishingStation() {
        return inputView.inputFinishingStationName();
    }
}
