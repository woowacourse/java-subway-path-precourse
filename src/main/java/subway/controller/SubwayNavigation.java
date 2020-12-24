package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;;

public class SubwayNavigation {

    private static final String OPTION_ONE = "1";
    private static final String QUIT_CODE = "Q";
    private String userOption = "";
    private PathManager pathManger;

    public SubwayNavigation() {
        pathManger = new PathManager();
    }

    public void run() {
        while (!userWantQuit()) {
            OutputView.printMainScreen();
            userOption = InputView.inputMainUserOption();
            System.out.println(userOption);
            runUserOption(userOption);
        }
    }

    private void runUserOption(String userOption) {
        if (userOption.equals(OPTION_ONE)) {
            pathManger.run();
        }
    }

    private boolean userWantQuit() {
        return userOption.equals(QUIT_CODE);
    }
}
