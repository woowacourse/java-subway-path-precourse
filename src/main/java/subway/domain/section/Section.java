package subway.domain.section;

public class Section {
    private int distance;
    private int time; // 단위 : 분

    public Section(int distance, int time) {
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
