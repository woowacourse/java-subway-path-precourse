package subway.domain;

public class NodeData {
    private Station nextStation;
    private int timeCost;
    private int distanceCost;

    public NodeData(Station nextStation, int timeCost, int distanceCost){
        this.nextStation = nextStation;
        this.timeCost = timeCost;
        this.distanceCost = distanceCost;
    }
}
