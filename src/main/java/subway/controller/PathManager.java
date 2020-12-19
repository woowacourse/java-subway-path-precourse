package subway.controller;

import java.util.List;
import org.jgrapht.traverse.
import subway.domain.DefaultLines;
import subway.domain.DefaultStations;
import subway.domain.Line;
import subway.domain.Station;
import subway.view.InputView;
import subway.view.OutputView;

public class PathManager {

    private static final String GO_BACK_CODE = "B";
    private final List<Line> defaultLines;
    private final List<Station> defaultStations;
    private String userOption;

    public PathManager() {
        defaultLines = DefaultLines.getDefaultLines();
        defaultStations = DefaultStations.getDefaultStations();
        userOption = "";
    }

    public void run() {
        while (!userWantGoBack()) {
            OutputView.printPathManagerScreen();
            userOption = InputView.inputPathUserOption();
        }
    }

    private boolean userWantGoBack() {
        return userOption.equals(GO_BACK_CODE);
    }
}
