package subway.domain.section;

public class SectionInformation {
    private int distance;
    private int time;

    public SectionInformation(int distance, int time) {
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
