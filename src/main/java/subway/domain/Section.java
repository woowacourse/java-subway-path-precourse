package subway.domain;

public class Section {
    private final String departureStation;
    private final String arrivalStation;
    private final int distance;
    private final int time;

    public Section(String departureStation, String arrivalStation, int distance, int time) {
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.distance = distance;
        this.time = time;
    }
}
