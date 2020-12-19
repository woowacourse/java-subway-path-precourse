package subway.domain;

public class Edge {
    private final Station leftEndStation;
    private final Station rightEndStation;
    private final int distance;
    private final int time;
    
    public Edge(Station leftEndStation, Station rightEndStation, int distance, int time) {
        this.leftEndStation = leftEndStation;
        this.rightEndStation = rightEndStation;
        this.distance = distance;
        this.time = time;
    }

    public Station getLeftEndStation() {
        return leftEndStation;
    }

    public Station getRightEndStation() {
        return rightEndStation;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
    
    public boolean stationsEquals(Station leftEndStation, Station rightEndStation) {
        return (leftEndStation == this.leftEndStation && rightEndStation == this.rightEndStation)
                || (leftEndStation == this.rightEndStation && rightEndStation == this.leftEndStation);
    }
}
