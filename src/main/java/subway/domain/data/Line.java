package subway.domain.data;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stationList = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStationInLine(Station station){
        stationList.add(station);
    }

    public void addStationListInLine(List<Station> stations){
        for(Station station : stations){
            stationList.add(station);
        }
    }
}
