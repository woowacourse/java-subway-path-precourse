package subway.domain;

public class Section {
    private int time;
    private int distance;

    public Section(int time, int distance) {
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