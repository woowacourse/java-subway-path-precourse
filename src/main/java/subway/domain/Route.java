package subway.domain;

public class Route {
    private Station station;
    private Station next;
    private Line line;
    private int distance;
    private int time;

    public Route(Station station, Station next, Line line, int distance, int time){
        this.station = station;
        this.next = next;
        this.line = line;
        this.distance = distance;
        this.time = time;
    }

    public boolean isTerminal(){
        if (this.next.equals(null))
            return true;
        return false;
    }
}
