package subway.domain;

public class Section {

    private final Station source;
    private final Station destination;
    private final Distance distance;
    private final Time time;

    private Section(final Station source, final Station destination,
        final Distance distance, final Time time) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.time = time;
    }

    public static Section newSectionWithStations(final Station source, final Station destination,
        final Distance distance, final Time time) {
        return new Section(source, destination, distance, time);
    }

    public Station getSource() {
        return source;
    }

    public Station getDestination() {
        return destination;
    }

    public Distance getDistance(){
        return distance;
    }

    public Time getTime() {
        return time;
    }
}
