package subway.domain;

public class Path {
    private Station departureStation;
    private Station arrivalStation;
    private int distance;
    private int time;

    public Path(Station departureStation, Station arrivalStation, int distance, int time) {
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.distance = distance;
        this.time = time;
    }

    public Station getDepartureStation() {
        return departureStation;
    }

    public Station getArrivalStation() {
        return arrivalStation;
    }

    public int getTime() {
        return time;
    }

    public int getDistance() {
        return distance;
    }

    /*
    로그 확인용
     */
    @Override
    public String toString() {
        return departureStation + " - ( " + distance + "km / " + time + "분 ) - " + arrivalStation;
    }
}
