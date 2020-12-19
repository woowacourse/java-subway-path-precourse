package subway.controller;

import java.util.List;
import subway.domain.DefaultLines;
import subway.domain.DefaultStations;
import subway.domain.Line;
import subway.domain.Station;
import subway.view.InputView;
import org.jgrapht.traverse.

public class MinCostCalculator {

    private final List<Line> lines;
    private final List<Station> stations;

    public MinCostCalculator() {
        lines = DefaultLines.getDefaultLines();
        stations = DefaultStations.getDefaultStations();
    }

    public void runToGetMinDistance() {
        String departureStation = InputView.inputStation();
        String arrivalStation = InputView.inputStation();
    }

    public void runToGetMinTime() {
    }

    public void calculateMinDistance() {
    }

    public void calculateMinTime() {
    }
}
