package subway.domain;

public class Edge {
    private String station1;
    private String station2;
    private int distance;
    private int time;

    public Edge(String station1, String station2, int distance, int time) {
        this.station1 = station1;
        this.station2 = station2;
        this.distance = distance;
        this.time = time;
    }

    public String getStation1() {
        return station1;
    }

    public String getStation2() {
        return station2;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
