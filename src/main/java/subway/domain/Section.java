package subway.domain;

public class Section {
    private final Station departureStation;
    private final Station arrivalStation;
    private final int distance;
    private final int duration;

    public Section(Station departureStation, Station arrivalStation, int distance, int duration) {
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.distance = distance;
        this.duration = duration;
    }

    public Station getDepartureStation() {
        return departureStation;
    }

    public Station getArrivalStation() {
        return arrivalStation;
    }

    public int getDistance() {
        return distance;
    }

    public int getDuration() {
        return duration;
    }
}