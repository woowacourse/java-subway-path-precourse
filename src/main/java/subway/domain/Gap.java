package subway.domain;

public class Gap {

    private final int distance;
    private final int time;

    public Gap(final int distance, final int time) {
        this.distance = distance;
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public int getDistance() {
        return distance;
    }
}
