package subway.controller.path;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.TimeGraphRepository;
import subway.view.InputView;

public class QuickestPathController extends PathController {

    public QuickestPathController(InputView inputView) {
        super(inputView);
    }

    @Override
    protected void calculatePath(String startingStationName, String finishingStationName) {
        DijkstraShortestPath quickestPath = TimeGraphRepository.getQuickestPath();
        List<String> pathInformation = quickestPath.getPath(startingStationName, finishingStationName).getVertexList();

        pathInformation.forEach(System.out::println);
    }
}
