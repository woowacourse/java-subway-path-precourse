package subway.controller;

import subway.exception.SubwayMapException;
import subway.service.PathService;
import subway.view.OutputView;

public class PathController {

    private PathController() {}

    public void calculateShortDistance() {
        try {
            PathService.calculateShortDistance();
        } catch (SubwayMapException e) {
            OutputView.printNewLine();
            OutputView.print(e.getMessage());
        }
    }

    public void calculateMinimumTime() {}

    public static PathController getInstance() {
        return PathController.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final PathController INSTANCE = new PathController();
    }
}
