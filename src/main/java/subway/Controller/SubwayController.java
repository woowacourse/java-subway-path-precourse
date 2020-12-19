package subway.Controller;

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
            OutputView.mainView();
            String status = InputView.inputFunction(scanner);
            if (status.equals("1")) {
                routeLookup();
            }
            if (status.equals("Q")) {
                break;
            }
        }
    }

    public void routeLookup() {
        OutputView.path_standardView();
        String status = InputView.inputFunction(scanner);
        if (status.equals("1")) {
            shortestDistance();
        }
        if (status.equals("2")) {
            shortestTime();
        }
    }

    public void shortestDistance() {
        String startStation = InputView.inputStartStation(scanner);
        String arrivalStation = InputView.inputArriveStation(scanner);
    }

    private void shortestTime() {
        String startStation = InputView.inputStartStation(scanner);
        String arrivalStation = InputView.inputArriveStation(scanner);
    }
}
