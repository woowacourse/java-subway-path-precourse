package subway.domain;

public class RequiredResources {
    private final Distance distance;
    private final Time time;

    public RequiredResources(int distance, int time) {
        this.distance = new Distance(distance);
        this.time = new Time(time);
    }
}
