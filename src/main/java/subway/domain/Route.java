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

    public Station getStation(){return this.station;}

    public Station getNext(){return this.next;}

    public int getDistance(){return this.distance;}
}
