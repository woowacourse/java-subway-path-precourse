package subway.service;

import org.jgrapht.GraphPath;
import subway.domain.Basis;
import subway.domain.PathResult;
import subway.util.PathCalculator;

public class PathService {

    private PathCalculator pathCalculator;

    public PathService() {
        this.pathCalculator = new PathCalculator();
    }

    public PathResult searchPath(Basis basis) {
        basis.validate();
        pathCalculator.initGraph(basis);
        GraphPath result = pathCalculator.calculate();
        return buildPathResult(result);
    }

    private PathResult buildPathResult(GraphPath result) {
        return null;
    }
}
