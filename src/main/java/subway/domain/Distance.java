package subway.domain;

public class Distance {
    private Station station1;
    private Station station2;
    private int physicalDistance;
    private int timeDistance;

    public Distance(Station station1, Station station2, int physicalDistance, int timeDistance) {
        this.station1 = station1;
        this.station2 = station2;
        this.physicalDistance = physicalDistance;
        this.timeDistance = timeDistance;
    }

    public Station getStation1() {
        return station1;
    }

    public Station getStation2() {
        return station2;
    }

    public int getPhysicalDistance() {
        return physicalDistance;
    }

    public int getTimeDistance(){
        return timeDistance;
    }
}
