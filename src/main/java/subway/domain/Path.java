package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class Path {
    private Line line;
    private WeightedMultigraph<Station, DefaultWeightedEdge> path =
            new WeightedMultigraph(DefaultWeightedEdge.class);

    public Path(Line line, Station... stations){
        this.line = line;
        registerStation(stations);
    }

    private void registerStation(Station... stations){
        for(Station station : stations){
            path.addVertex(station);
        }
    }


}
