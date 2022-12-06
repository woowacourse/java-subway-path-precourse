package subway.domain.global;

import subway.domain.graph.GraphController;
import subway.domain.line.LineRepository;
import subway.domain.station.StationRepository;
import subway.domain.util.ExceptionHandler;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.domain.global.SystemCommand.*;

public class SystemController {
    private boolean systemContinue = true;
    private final GraphController graphController = new GraphController();

    public SystemController() {
        StationRepository.setUp();
        LineRepository.setUp();
        graphController.setUp();
    }

    public void run() {
        while (systemContinue) {
            try {
                OutputView.printMainPage();
//                String input = ExceptionHandler.repeatForValidInput(InputView::readMainCommand);
//                executeMainCommand(input);
            } catch (IllegalArgumentException e) {
                OutputView.print(e.getMessage());
            }
        }
    }

    private void executeMainCommand(String input) {
        SystemCommand command = convertToCommand(input);

//        if (command == STATION_MANAGEMENT) stationController.run();
        if (command == QUIT) systemContinue = false;
    }

}
