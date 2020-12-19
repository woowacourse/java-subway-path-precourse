package subway.domain;

public class Edge {
    private int endStation;
    private int distance;
    private int time;
    public Edge(int endStation, int distance, int time) {
        if (distance <= 0) { throw new IllegalArgumentException("[ERROR] 거리는 양의 정수입니다.");}
        if (time <= 0) { throw new IllegalArgumentException("[ERROR] 시간은 양의 정수입니다.");}
        this.endStation = endStation;
        this.distance = distance;
        this.time = time;
    }

    public int getEndStation() {
        return endStation;
    }

    public int getDistance() {
        return endStation;
    }

    public int getTime() {
        return endStation;
    }
}
