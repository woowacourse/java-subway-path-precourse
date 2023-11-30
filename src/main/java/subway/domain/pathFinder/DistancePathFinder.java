package subway.domain.pathFinder;

import subway.domain.LineRepository;
import subway.domain.UnitPath;

public class DistancePathFinder extends StationPathFinder{
    public DistancePathFinder(LineRepository lineRepository) {
        super(lineRepository);
    }

    @Override
    protected int getCost(UnitPath path) {
        return path.getDistance();
    }
}
