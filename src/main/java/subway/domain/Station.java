package subway.domain;

import java.util.HashSet;

public class Station {
    private String name;
    private HashSet<String> stationSet = new HashSet<String>();
   
    public Station(String name) {
        this.name = name;
        registerStationSet(name);
    }

    public String getName() {
        return name;
    }

    public void registerStationSet(String stationName) {
    	stationSet.add(stationName);
    }
    
    public void deleteStationSet(String stationName) {
    	stationSet.remove(stationName);
    }
}
