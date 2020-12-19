package subway.domain;

public class Section {

    private Line line;

    private Station departure;
    private Station arrival;
    private int distance;
    private int costTime;

    public Section(String lineName, String departureName, String arrivalName, int distance, int costTime) {
        Line line = LineRepository.findLine(lineName);
        Station departure = StationRepository.findStation(departureName);
        Station arrival = StationRepository.findStation(arrivalName);

        this.line = line;
        this.departure = departure;
        this.arrival = arrival;
        this.distance = distance;
        this.costTime = costTime;
    }

    public Station getDeparture() {
        return departure;
    }

    public Station getArrival() {
        return arrival;
    }

    public int getCostTime() {
        return costTime;
    }
}
