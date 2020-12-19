package subway.enums;

import java.util.Arrays;
import java.util.List;

public enum DistanceToStation {
    LINE_2(Arrays.asList(2, 2)),
    LINE_3(Arrays.asList(3, 6, 1)),
    LINE_SINBUNDANG(Arrays.asList(2, 10));

    private List<Integer> distances;

    DistanceToStation(List<Integer> distances) {
        this.distances = distances;
    }

    public List<Integer> getDistance() {
        return distances;
    }
}
