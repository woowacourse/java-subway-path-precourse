package subway.domain;

import java.util.Objects;

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

    public Path(Station srcStation, Station dstStation) {
        this.srcStation = srcStation;
        this.dstStation = dstStation;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Path)) return false;
        Path path = (Path) o;
        return Objects.equals(srcStation, path.srcStation) && Objects.equals(dstStation, path.dstStation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(srcStation, dstStation);
    }
}
