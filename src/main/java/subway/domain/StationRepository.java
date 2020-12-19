package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
	 private static final List<Station> stations = new ArrayList<>(Arrays.asList(new Station("교대역"),new Station("강남역"),new Station("역삼역"),new Station("남부터미널역"),new Station("양재역"),
	    		new Station("양재시민의숲역"),new Station("매봉역")));
	 
    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
    
    public static Station getStationByName(String stationName) {
    	for ( Station station : stations()) {
    		if (stationName.equals(station.getName()))
    			return station;
    	}
    	return null;
    }
    
    public static boolean check_station(String stationName) {
    	for ( Station station : stations()) {
    		if (stationName.equals(station.getName()))
    			return true;
    	}
    	System.out.println("[ERROR] 존재하지 않는 역입니다.");
    	return false;
    }

    public static void deleteAll() {
        stations.clear();
    }
}
