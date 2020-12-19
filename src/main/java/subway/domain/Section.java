package subway.domain;

public class Section {

    private Station upStation;
    private Station downStation;
    private int distance;
    private int time;

    public Section(Station upStation, Station downStation, int distance, int time) {
        this.upStation = upStation;
        this.downStation = downStation;
        this.distance = distance;
        this.time = time;
    }

    public Station getUpStationName() {
        return upStation;
    }

    public Station getDownStationName() {
        return downStation;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
