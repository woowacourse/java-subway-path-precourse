package subway.domain.Dijkstra;

import org.jgrapht.graph.DefaultWeightedEdge;

public class IntervalEdge extends DefaultWeightedEdge {
    private Station start;
    private Station end;
    private Cost cost;
    
    public IntervalEdge(Station start, Station end, Cost cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    public Station getStart() {
        return start;
    }

    public Station getEnd() {
        return end;
    }

    public Cost getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return start.getName() + "-" + end.getName();
    }
}
