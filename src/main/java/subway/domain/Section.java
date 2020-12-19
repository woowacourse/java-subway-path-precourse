package subway.domain;

public class Section {
    private String linkedStationName;
    private int distance;
    private int time;

    public Section(String linkedStationName, int distance, int time) {
        this.linkedStationName = linkedStationName;
        this.distance = distance;
        this.time = time;
    }

    public String getLinkedStationName() {
        return linkedStationName;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
