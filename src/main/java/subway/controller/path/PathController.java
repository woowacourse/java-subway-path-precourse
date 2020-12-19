package subway.controller.path;

import subway.controller.Controller;
import subway.view.InputView;

public abstract class PathController implements Controller {

    public final InputView inputView;

    public PathController(InputView inputView) {
        this.inputView = inputView;
    }

    public abstract void run();

    protected String getStartingStation() {
        return inputView.inputStartingStationName();
    }
}
