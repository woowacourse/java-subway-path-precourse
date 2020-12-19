package subway.domain;

public class Section {
    private Line line;
    private Station departureStation;
    private Station arriavalStation;
    private int distance;
    private int costTime;

    public Section(String lineName, String departureName, String arrivalName, int distance, int costTime) {
        Line line = LineRepository.findLine(lineName);
        Station departure = StationRepository.findStation(departureName);
        Station arrival = StationRepository.findStation(arrivalName);

        this.line = line;
        this.departureStation = departure;
        this.arriavalStation = arrival;
        this.distance = distance;
        this.costTime = costTime;
    }

}
