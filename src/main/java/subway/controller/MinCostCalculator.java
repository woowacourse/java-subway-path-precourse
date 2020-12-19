package subway.controller;

import java.util.List;
import subway.domain.DefaultLines;
import subway.domain.DefaultStations;
import subway.domain.Line;
import subway.domain.Station;
import subway.view.InputView;
import org.jgrapht.traverse.

public class MinCostCalculator {

    private static final String SAME_STATION_ERROR = "출발역과 도착역은 달라야합니다";
    private static final String ERROR_PREFIX = "[ERROR]: ";
    private final List<Line> lines;
    private final List<Station> stations;
    private String departureStation;
    private String arrivalStation;

    public MinCostCalculator() {
        lines = DefaultLines.getDefaultLines();
        stations = DefaultStations.getDefaultStations();
    }

    public void runToGetMinDistance() {
        getStationNames();


    }

    public void runToGetMinTime() {
    }

    private void getStationNames() {
        try {
            String departureStation = InputView.inputStation();
            String arrivalStation = InputView.inputStation();
            if (departureStation.equals(arrivalStation)) {
                throw new IllegalArgumentException(SAME_STATION_ERROR);
            }
        } catch (Exception e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            getStationNames();
        }
    }

    public void calculateMinDistance() {
    }

    public void calculateMinTime() {
    }
}
