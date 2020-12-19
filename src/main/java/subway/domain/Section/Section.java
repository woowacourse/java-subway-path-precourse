package subway.domain.section;

import subway.domain.line.Line;
import subway.domain.station.Station;

public class Section {

    private Line line;
    private Station preStation;
    private Station nextStation;
    private Time time;
    private Distance distance;

    private Section(Line line, Station preStation, Station nextStation, Time time,
        Distance distance) {
        this.line = line;
        this.preStation = preStation;
        this.nextStation = nextStation;
        this.time = time;
        this.distance = distance;
    }

    public static Section create(Line line, Station preStation, Station nextStation, Time time,
        Distance distance) {
        return new Section(line, preStation, nextStation, time, distance);
    }

    public Time getTime() {
        return time;
    }

    public Distance getDistance() {
        return distance;
    }

    public Station getPreStation() {
        return preStation;
    }

    public Station getNextStation() {
        return nextStation;
    }

    public boolean isMatchStations(Station preStation, Station nextStation) {

        if (this.preStation.equals(preStation) && this.nextStation.equals(nextStation)) {
            return true;
        }
        if (this.preStation.equals(nextStation) && this.nextStation.equals(preStation)) {
            return true;
        }
        return false;
    }
}
