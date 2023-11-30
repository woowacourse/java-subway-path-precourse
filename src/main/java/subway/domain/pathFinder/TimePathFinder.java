package subway.domain.pathFinder;

import subway.domain.repository.LineRepository;
import subway.domain.UnitPath;

public class TimePathFinder extends StationPathFinder{
    public TimePathFinder() {
        super();
    }

    @Override
    protected int getCost(UnitPath path) {
        return path.getTime();
    }
}
