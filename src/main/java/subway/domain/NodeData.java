package subway.domain;

public class NodeData {
    private Station beforeStation;
    private Station nextStation;
    private int timeCost;
    private int distanceCost;

    public NodeData(Station beforeStation, Station nextStation, int timeCost, int distanceCost) {
        this.beforeStation = beforeStation;
        this.nextStation = nextStation;
        this.timeCost = timeCost;
        this.distanceCost = distanceCost;
    }

    public String getBeforeStation() {
        return beforeStation.getName();
    }

    public String getNextStation() {
        return nextStation.getName();
    }

    public int getTimeCost() {
        return timeCost;
    }

    public int getDistanceCost() {
        return distanceCost;
    }
}
