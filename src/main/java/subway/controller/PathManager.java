package subway.controller;

import subway.domain.DefaultSubwayGraph;
import subway.view.InputView;
import subway.view.OutputView;

public class PathManager {

    private static final String GO_BACK_CODE = "B";
    private static final String OPTION_ONE = "1";
    private static final String OPTION_TWO = "2";
    private String userOption;
    private MinCostCalculator minCostCalculator;

    public PathManager() {
        minCostCalculator = new MinCostCalculator();
        userOption = "";
    }

    public void run() {
        while (!userWantGoBack()) {
            OutputView.printPathManagerScreen();
            userOption = InputView.inputPathUserOption();
            runUserOption(userOption);
        }
    }

    private void runUserOption(String userOption) {
        if (userOption.equals(OPTION_ONE)) {
            minCostCalculator.runToGetMinDistance();
        }
        if (userOption.equals(OPTION_TWO)) {
            minCostCalculator.runToGetMinTime();
        }
    }

    private boolean userWantGoBack() {
        return userOption.equals(GO_BACK_CODE);
    }
}
