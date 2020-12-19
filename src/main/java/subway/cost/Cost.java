package subway.cost;

public class Cost {
    private int distance;
    private int time;

    public Cost(int distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
