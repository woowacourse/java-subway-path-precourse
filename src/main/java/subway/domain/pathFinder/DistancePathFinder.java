package subway.domain.pathFinder;

import subway.domain.repository.LineRepository;
import subway.domain.UnitPath;

public class DistancePathFinder extends StationPathFinder{
    public DistancePathFinder() {
        super();
    }

    @Override
    protected int getCost(UnitPath path) {
        return path.getDistance();
    }
}
