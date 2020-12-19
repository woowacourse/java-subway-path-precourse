package subway.domain.Dijkstra;

import subway.domain.Dijkstra.Vertex;

public class Edge {
    private Vertex start;
    private Vertex end;
    private Cost cost;
    
    public Edge(Vertex start, Vertex end, Cost cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
    
    
}
