package subway.controller.path;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.graph.DistanceGraphRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class ShortestPathController extends PathController {

    public ShortestPathController(InputView inputView) {
        super(inputView);
    }

    @Override
    protected void calculatePath(String startingStationName, String finishingStationName) {
        DijkstraShortestPath shortestPath = DistanceGraphRepository.getShortestPath();
        List<String> pathInformation = shortestPath.getPath(startingStationName, finishingStationName).getVertexList();

        OutputView.printResult(pathInformation);
    }
}
