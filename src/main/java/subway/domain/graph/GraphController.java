package subway.domain.graph;

import subway.domain.global.SystemCommand;
import subway.domain.util.ExceptionHandler;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.domain.graph.GraphCommand.*;

public class GraphController {
    private final GraphService graphService = new GraphService();

    public void setUp() {
        graphService.setUp();
    }

    public void run() {
        OutputView.printPathPage();
        String input = ExceptionHandler.repeatForValidInput(InputView::readDetailCommand);
        executePathCommand(input);
    }

    private void executePathCommand(String input) {
        GraphCommand command = convertToCommand(input);
        if (command == SHORTEST_DISTANCE) ;
        if (command == SHORTEST_TIME) ;
        if (command == BACK) return;
    }

}
