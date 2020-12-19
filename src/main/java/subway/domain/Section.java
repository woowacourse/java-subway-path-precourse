package subway.domain;

public class Section {

    private final Station source;
    private final Station destination;
    private final Time time;
    private final Distance distance;

    private Section(final Station source, final Station destination,
        final Distance distance, final Time time) {
        this.source = source;
        this.destination = destination;
        this.time = time;
        this.distance = distance;
    }

    public static Section newSection(final Station source, final Station destination,
        final Distance distance, final Time time) {
        return new Section(source, destination, distance, time);
    }

    public boolean isSourceDestinationByName(String name) {
        return name.equals(source.getName()) || name.equals(destination);
    }

    public Distance getDistance() {
        return distance;
    }

    public Time getTime() {
        return time;
    }

    public Station getSource() {
        return source;
    }

    public Station getDestination(){
        return destination;
    }
}
