package subway.domain;

public class Edge {
    private Section source;
    private Section destination;
    private int distance;
    private int time;

    public Section getSource() {
        return source;
    }

    public void setSource(Section source) {
        this.source = source;
    }

    public Section getDestination() {
        return destination;
    }

    public void setDestination(Section destination) {
        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
