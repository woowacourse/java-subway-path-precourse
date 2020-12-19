package subway;

import subway.line.LineController;
import subway.station.StationController;
import subway.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        SubwayPath subwayPath = new SubwayPath(inputView);
        StationController stationController = new StationController();
        stationController.stationInitialize();
        LineController lineController = new LineController();
        lineController.lineInitialize();

        boolean running = true;
        while (running) {
            running = subwayPath.run();
        }
    }
}
