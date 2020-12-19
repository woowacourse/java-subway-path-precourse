package subway.controller;

import java.util.Scanner;
import subway.controller.constants.QuestionNumber;

public enum PathOption {
    SHORT_DISTANCE(QuestionNumber.ONE.getOption()) {
        @Override
        public void processUnit(Scanner scanner) {
            ShortestDistancePathFinder distanceFinder = new ShortestDistancePathFinder(scanner);
            distanceFinder.findPath();
        }
    },
    SHORT_TIME(QuestionNumber.TWO.getOption()) {
        @Override
        public void processUnit(Scanner scanner) {
            ShortestTimePathFinder distanceFinder = new ShortestTimePathFinder(scanner);
            distanceFinder.findPath();
        }
    },
    BACK(QuestionNumber.BACK.getOption()){
        @Override
        public void processUnit(Scanner scanner) {
        }
    };

    private String option;

    abstract public void processUnit(Scanner scanner);

    private PathOption(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

}
