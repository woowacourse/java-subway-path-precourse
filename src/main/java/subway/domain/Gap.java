package subway.domain;

public class Gap {

    private final int time;
    private final int distance;

    public Gap(final int time, final int distance) {
        this.time = time;
        this.distance = distance;
    }

    public int getTime() {
        return time;
    }

    public int getDistance() {
        return distance;
    }
}
