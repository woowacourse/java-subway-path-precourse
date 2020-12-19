package subway.domain.Dijkstra;

public class Interval {
    private Station start;
    private Station end;
    private Cost cost;
    
    public Interval(Station start, Station end, Cost cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
    
    
}
