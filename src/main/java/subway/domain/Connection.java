package subway.domain;

public class Connection {

    private final String source;
    private final String destination;
    private final int distance; // (km) 단위
    private final int time; // (분) 단위

    public Connection(final String source, final String destination, final int distance, final int time) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.time = time;
    }

    public Connection getReverse() {
        return new Connection(destination, source, distance, time);
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
