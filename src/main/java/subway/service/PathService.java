package subway.service;

import subway.domain.Basis;
import subway.util.PathCalculator;

public class PathService {

    private PathCalculator pathCalculator;

    public PathService() {
        this.pathCalculator = new PathCalculator();
    }

    public String searchPath(Basis basis) {
        basis.validate();
        pathCalculator.initGraph(basis);
        pathCalculator.calculate();
        return null;
    }
}
