package subway;

import java.util.List;

public class PathResult {
    List<String> shortestPath;
    int distance;
    int requiredTime;

    public PathResult(List<String> shortestPath, int distance, int requiredTime) {
        this.shortestPath = shortestPath;
        this.distance = distance;
        this.requiredTime = requiredTime;
    }

    public List<String> getShortestPath() {
        return shortestPath;
    }

    public int getDistance() {
        return distance;
    }

    public int getRequiredTime() {
        return requiredTime;
    }
}
