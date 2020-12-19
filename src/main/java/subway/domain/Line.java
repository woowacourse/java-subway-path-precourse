package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stations = new ArrayList<Station>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    
    public static Station get_station_by_name(String name) {
		for (Station station : StationRepository.stations()) {
			if (name.equals(station.getName())) {
				return station;
			}
		}
		return null;
	}
    
    public Line(String name, List<String> station_name) {
    	this.name = name;
    	for (String station : station_name) {    		
    		stations.add(get_station_by_name(station));
    	}
    }
}
