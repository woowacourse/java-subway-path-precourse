package subway.domain;

public class Section {
    private Station sourceStation;
    private Station targetStation;
    private int distance;
    private int time;

    public Section(Station sourceStation, Station targetStation, int distance, int time) {
        this.sourceStation = sourceStation;
        this.targetStation = targetStation;
        this.distance = distance;
        this.time = time;
    }

    public boolean matches(String sourceStationName, String targetStationName) {
        if (sourceStation.matches(sourceStationName)
                && targetStation.matches(targetStationName))
            return true;
        return false;
    }

    public String getSourceStationName() {
        return sourceStation.getName();
    }

    public String getTargetStationName() {
        return targetStation.getName();
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
