package subway.domain;

import java.util.List;

public class GraphDTO {

    private int distance;
    private int time;
    private List<Station> path;

    public GraphDTO(int distance, int time, List<Station> path) {
        this.distance = distance;
        this.time = time;
        this.path = path;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    public List<Station> getPath() {
        return path;
    }
}
