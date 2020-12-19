package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class SubwayTimeRepository {
    private static final WeightedMultigraph<Station, DefaultWeightedEdge> subwayTime = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static WeightedMultigraph<Station, DefaultWeightedEdge> subwayTime(){
        return subwayTime;
    }
    public static void addStation(Station station){
        subwayTime.addVertex(station);
    }

    public static void setPathWeight(Station source, Station target, int weight){
        subwayTime.setEdgeWeight(subwayTime.addEdge(source, target), weight);
    }

    public static int getEdgeWeightWithTwoStations(Station source, Station target){
        return (int) subwayTime.getEdgeWeight(subwayTime.getEdge(source, target));
    }
}
