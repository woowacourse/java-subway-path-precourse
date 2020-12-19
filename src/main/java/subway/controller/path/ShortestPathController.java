package subway.controller.path;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.DistanceGraphRepository;
import subway.view.InputView;

public class ShortestPathController extends PathController {

    public ShortestPathController(InputView inputView) {
        super(inputView);
    }

    @Override
    protected void calculatePath(String startingStationName, String finishingStationName) {
        DijkstraShortestPath shortestPath = DistanceGraphRepository.getShortestPath();
        List<String> pathInformation = shortestPath.getPath(startingStationName, finishingStationName).getVertexList();

        pathInformation.forEach(System.out::println);
    }
}
