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

    private List<Line> lines;
    private List<Station> stations;
    private String userOption = "";
    private static final String QUIT_CODE = "Q";

    public SubwayNavigation() {
        stations = DefaultStations.getDefaultStations();
        lines = DefaultLines.getDefaultLines();
    }

    public void run() {
        while (!userWantQuit()) {
            OutputView.printMainScreen();
            userOption = InputView.inputMainUserOption();
            runUserOption(userOption);
        }
    }

    private boolean userWantQuit() {
        return userOption.equals(QUIT_CODE);
    }
}
