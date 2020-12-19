package subway.service;

import org.jgrapht.GraphPath;
import subway.domain.Basis;
import subway.domain.PathResult;
import subway.domain.Station;
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
        List<Station> stations = result.getVertexList();
        return new PathResult(result.getWeight(), result.getWeight(), stations);
    }
}
