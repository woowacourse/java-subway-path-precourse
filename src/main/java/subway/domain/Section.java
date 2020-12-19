package subway.domain;

public class Section {
    private Station departureStation;
    private Station arriavalStation;
    private int distance;
    private int costTime;

    public Section(Station departureStation, Station arriavalStation, int distance, int costTime) {
        this.departureStation = departureStation;
        this.arriavalStation = arriavalStation;
        this.distance = distance;
        this.costTime = costTime;
    }

}
