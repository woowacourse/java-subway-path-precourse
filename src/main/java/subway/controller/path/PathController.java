package subway.controller.path;

import subway.controller.Controller;
import subway.utils.PathControllerValidator;
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
            String startingStationName = getStartingStationName();
            String finishingStationName = getFinishingStationName();
            PathControllerValidator.validateStations(startingStationName, finishingStationName);

            calculatePath(startingStationName, finishingStationName);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }

    protected abstract void calculatePath(String startingStationName, String finishingStationName);

    protected String getStartingStationName() {
        return inputView.inputStartingStationName();
    }

    protected String getFinishingStationName() {
        return inputView.inputFinishingStationName();
    }
}
