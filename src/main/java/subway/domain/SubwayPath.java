package subway.domain;

public class SubwayPath {
    private String departureStation;
    private String arrivalStation;
    private int distance;
    private int time;

    public SubwayPath(String departureStation, String arrivalStation, int distance, int time) {
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.distance = distance;
        this.time = time;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
