package subway.controller.path;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.graph.TimeGraphRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.message.ErrorMessage;

public class QuickestPathController extends PathController {

    public QuickestPathController(InputView inputView) {
        super(inputView);
    }

    @Override
    protected void calculatePath(String startingStationName, String finishingStationName) {
        try {
            DijkstraShortestPath quickestPath = TimeGraphRepository.getQuickestPath();
            List<String> pathInformation = quickestPath
                    .getPath(startingStationName, finishingStationName).getVertexList();

            OutputView.printResult(pathInformation);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(ErrorMessage.CONNECTION_NONE);
        }
    }
}
