package subway.controller;

import java.util.List;
import subway.domain.DefaultLines;
import subway.domain.DefaultStations;
import subway.domain.Line;
import subway.domain.Station;
import org.jgrapht.traverse.
import subway.view.InputView;
import subway.view.OutputView;;

public class SubwayNavigation {

    private static final String OPTION_ONE = "1";
    private String userOption = "";
    private static final String QUIT_CODE = "Q";
    private PathManager pathManger;

    public SubwayNavigation() {
        pathManger = new PathManager();
    }

    public void run() {
        while (!userWantQuit()) {
            OutputView.printMainScreen();
            userOption = InputView.inputMainUserOption();
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
