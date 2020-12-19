package subway.service;

import org.jgrapht.GraphPath;
import subway.domain.*;
import subway.repository.PathRepository;
import subway.util.PathCalculator;

import java.util.List;

public class PathService {

    private PathCalculator pathCalculator;
    private Basis basis;

    public PathService() {
        this.pathCalculator = new PathCalculator();
    }

    public PathResult searchPath(Basis basis) {
        this.basis = basis;
        this.basis.validate();
        pathCalculator.initGraph(this.basis);
        GraphPath result = pathCalculator.calculate();
        return buildPathResult(result);
    }

    private PathResult buildPathResult(GraphPath result) {
        if (basis.getBasis().equals(BasisChoice.DISTANCE.getCode()))
            return new PathResult(result.getWeight(), calcTotalTime(result), result.getVertexList());
        if (basis.getBasis().equals(BasisChoice.TIME.getCode()))
            return new PathResult(calcTotalDistance(result), result.getWeight(), result.getVertexList());
        return null;    // TODO: 예외처리
    }

    private double calcTotalDistance(GraphPath result) {
        List<Station> stations = result.getVertexList();
        double totalDistance = 0;
        for (int i = 0; i < stations.size() - 1; i++)
            totalDistance += PathRepository.getDistance(new Path(stations.get(i), stations.get(i + 1)));
        return totalDistance;
    }

    private double calcTotalTime(GraphPath result) {
        List<Station> stations = result.getVertexList();
        double totalTime = 0;
        for (int i = 0; i < stations.size() - 1; i++)
            totalTime += PathRepository.getTime(new Path(stations.get(i), stations.get(i + 1)));
        return totalTime;
    }
}
