package subway.controller;

public class PathController {
    private PathController() {}

    public void calculateShortDistance() {}

    public void calculateMinimumTime() {}

    public static PathController getInstance() {
        return PathController.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final PathController INSTANCE = new PathController();
    }
}
