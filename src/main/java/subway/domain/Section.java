package subway.domain;

public class Section {
    private String start;
    private String end;
    private int distance;
    private int time;

    public Section(String start, String end, int distance, int time) {
        this.start = start;
        this.end = end;
        this.distance = distance;
        this.time = time;
    }
    
    public boolean isSectionBetween(String startStation, String endStation) {
        return start.equals(startStation) && end.equals(endStation);
    }
    
    public int getDistance() {
        return distance;
    }
    
    public int getTime() {
        return time;
    }
}
