package subway;

import subway.domain.Station;
import subway.view.InputView;

import java.util.Scanner;

public class RouteCheckController {
    private static final String SAME_STATION_ERROR = "[ERROR] 출발역과 도착역이 동일합니다.";

    private final Scanner scanner;

    public RouteCheckController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void selectShortestDistance() {
        try {
            Station startStation = InputView.inputStartStation(scanner);
            Station arrivalStation = InputView.inputArrivalStation(scanner);
            validateSameStation(startStation, arrivalStation);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void validateSameStation(Station startStation, Station arrivalStation) {
        if (startStation.equals(arrivalStation)) {
            throw new IllegalArgumentException(SAME_STATION_ERROR);
        }
    }
}
