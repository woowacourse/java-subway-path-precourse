package subway.domain;

public class Path {

    private Station srcStation;
    private Station dstStation;
    private double distance;
    private double time;

    public Path(Station srcStation, Station dstStation, int distance, int time) {
        this.srcStation = srcStation;
        this.dstStation = dstStation;
        this.distance = distance;
        this.time = time;
    }

    public Station getSrcStation() {
        return srcStation;
    }

    public Station getDstStation() {
        return dstStation;
    }

    public double getDistance() {
        return distance;
    }

    public double getTime() {
        return time;
    }
}
