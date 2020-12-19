package subway.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Distances {

    private final List<Distance> distances;

    public Distances(List<Distance> distances) {
        this.distances = distances;
    }

    public Distances(Integer... distances) {
        this.distances = Arrays.stream(distances)
                .map(Distance::new)
                .collect(Collectors.toList());
    }

    public List<Integer> getDistances() {
        return distances.stream()
                .map(Distance::getDistance)
                .collect(Collectors.toList());
    }
}
