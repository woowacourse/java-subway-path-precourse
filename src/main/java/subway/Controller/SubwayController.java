package subway.Controller;

import subway.Category.Category;
import subway.Exception.SameStationException;
import subway.Service.ShortestDistanceService;
import subway.Service.ShortestTimeService;
import subway.domain.Station;
import subway.domain.StationRepository;
import views.InputView;
import views.OutputView;

import java.util.Scanner;

public class SubwayController {

    public final Scanner scanner;

    public SubwayController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        while (true) {
            try {
                OutputView.mainView();
                String status = InputView.inputFunction(scanner);
                Category.MAIN.isValidFunction(status, Category.MAIN.getActionType());

                if (status.equals("1")) {
                    routeLookup();
                }
                if (status.equals("Q")) {
                    break;
                }
            } catch (IllegalArgumentException ie) {
                System.out.println(ie.getMessage());
            }
        }
    }

    public void routeLookup() {
        try {
            OutputView.path_standardView();
            String status = InputView.inputFunction(scanner);
            Category.ROUTE.isValidFunction(status, Category.ROUTE.getActionType());

            Station startStation = StationRepository.findByName(InputView.inputStartStation(scanner));
            Station arrivalStation = StationRepository.findByName(InputView.inputArriveStation(scanner));
            isSameStation(startStation, arrivalStation);

            if (status.equals("1")) {
                shortestDistance(startStation, arrivalStation);
            }
            if (status.equals("2")) {
                shortestTime(startStation, arrivalStation);
            }
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            routeLookup();
        }
    }

    public void shortestDistance(Station startStation, Station arriveStation) {
        ShortestDistanceService shortestDistanceService = new ShortestDistanceService();
        shortestDistanceService.lookup(startStation, arriveStation);
        OutputView.path_lookup_result();
    }

    private void shortestTime(Station startStation, Station arriveStation) {
        ShortestTimeService shortestTimeService = new ShortestTimeService();
    }

    public static void isSameStation(Station station1, Station station2) {
        if (station1.equals(station2)) {
            throw new SameStationException();
        }
    }
}
