package subway.domain;

public class Line {
    private String name;
    private int distance;
    private int time;

    public Line(String name, int distance, int time) {
        this.name = name;
        this.distance = distance;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
    	return distance;
    }
    
    public int getTime() {
    	return time;
    }
    
    
   
}
