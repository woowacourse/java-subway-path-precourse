package subway.domain.section;

import org.jgrapht.alg.cycle.TiernanSimpleCycles;

public class DistanceAndTime implements Distance, Time {
    private int distance;
    private int time;

    public DistanceAndTime(int distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public int getTime() {
        return time;
    }
}
