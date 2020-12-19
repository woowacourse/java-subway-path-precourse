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

    public boolean hasStation(String station1, String station2) {
        if ((station1.equals(arrival.getName()) || station2.equals(arrival.getName()))
                && (station1.equals(departure.getName()) || station2.equals(departure.getName()))) {
            return true;
        }
        return false;
    }

    public int getDistance() {
        return distance;
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
