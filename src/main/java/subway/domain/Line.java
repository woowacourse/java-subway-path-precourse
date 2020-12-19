package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class Line {
    private String name;
    private WeightedMultigraph<Station, DefaultWeightedEdge> distancePath;
    private WeightedMultigraph<Station, DefaultWeightedEdge> timePath;

    public Line(String name) {
        this.name = name;
        this.distancePath = new WeightedMultigraph(DefaultWeightedEdge.class);
        this.timePath = new WeightedMultigraph(DefaultWeightedEdge.class);
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station) {
        this.distancePath.addVertex(station);
        this.timePath.addVertex(station);
    }

    public void addPathInformation(Station start, Station end, int distance, int time) {
        this.distancePath.setEdgeWeight(this.distancePath.addEdge(start, end), distance);
        this.timePath.setEdgeWeight(this.timePath.addEdge(start, end), time);
    }

    public WeightedMultigraph<Station, DefaultWeightedEdge> getDistancePath() {
        return distancePath;
    }

    public WeightedMultigraph<Station, DefaultWeightedEdge> getTimePath() {
        return timePath;
    }
}
