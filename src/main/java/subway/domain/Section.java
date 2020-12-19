package subway.domain;

public class Section {
    private Station StartStation;
    private Station EndStation;
    private int distance;
    private int minute;

    public Section(Station startStation, Station endStation, int distance, int minute){
        this.StartStation = startStation;
        this.EndStation = endStation;
        this.distance = distance;
        this.minute = minute;
    }



}
