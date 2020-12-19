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

    public void print(){
        System.out.println("현재 역: "+this.station.getName());
        System.out.println("다음 역: "+this.next.getName());
        System.out.println("노선: "+this.line.getName());
        System.out.println("거리: "+this.distance+"km, 시간: "+this.time+"분");
        System.out.println();
    }

    public Station getStation(){return this.station;}

    public Station getNext(){return this.next;}

    public int getDistance(){return this.distance;}
}
