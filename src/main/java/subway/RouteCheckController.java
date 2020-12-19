package subway;

import subway.domain.Station;
import subway.view.InputView;

import java.util.Scanner;

public class RouteCheckController {

    private final Scanner scanner;

    public RouteCheckController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void selectShortestDistance() {
        try {
            Station startStation = InputView.inputStartStation(scanner);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
