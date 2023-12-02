package subway;

import subway.controller.GraphController;
import subway.controller.LineController;
import subway.controller.StationController;
import subway.controller.SubwayController;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

import static subway.repository.LineRepository.lines;
import static subway.repository.StationRepository.stations;

public class Application {

    private static final LineController lineController = new LineController();
    private static final StationController stationController = new StationController();
    private static final SubwayController subwayController = new SubwayController();
    private static final GraphController graphController = new GraphController();
    public static void main(String[] args) {
        lineController.initLine();
        stationController.initStation();
        subwayController.initSubway();
        graphController.initGraph();
        final Scanner scanner = new Scanner(System.in);
        InputView.init(scanner);
        subwayController.start();
    }
}
