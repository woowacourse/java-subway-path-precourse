package subway.domain;

public class Section {

    private Station fromStation;
    private Station toStation;
    private int distance;
    private int time;

    public Section(Station fromStation, Station toStation, int distance, int time) {
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.distance = distance;
        this.time = time;
    }

    public Station getFromStation() {
        return fromStation;
    }

    public Station getToStation() {
        return toStation;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    public boolean isSameSection(Station fromStation, Station toStation) {
        if (fromStation.equals(toStation)) {
            return false;
        }

        if (!this.fromStation.equals(fromStation) && !this.fromStation.equals(toStation)) {
            return false;
        }

        return this.toStation.equals(fromStation) || this.toStation.equals(toStation);
    }
}
