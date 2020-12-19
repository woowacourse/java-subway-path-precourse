package subway.domain;

public class Section {
    private int end;
    private int distance;
    private int time;

    public Section(int end, int distance, int time) {
        this.end = end;
        this.distance = distance;
        this.time = time;
    }

    public int getEndStation() {
        return end;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
