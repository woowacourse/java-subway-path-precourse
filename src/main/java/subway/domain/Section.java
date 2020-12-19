package subway.domain;

public class Section {
    private String StartStation;
    private String EndStation;
    private int distance;
    private int minute;

    public Section(String startStation, String endStation, int distance, int minute){
        this.StartStation = startStation;
        this.EndStation = endStation;
        this.distance = distance;
        this.minute = minute;
    }

    public int getDistance(){
        return distance;
    }

    public int getMinute(){
        return minute;
    }

    public boolean isSection(String startStation, String endStation){
        return this.StartStation.equals(startStation) && this.EndStation.equals(endStation);
    }
}
