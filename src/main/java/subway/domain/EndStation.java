package subway.domain;

public class EndStation {
    private final String stationName;
    public EndStation(String name){
        validateStation(name);
        stationName = name;
    }

    void validateStation(String name){
        for(Station station : StationRepository.stations()){
            if(station.getName().equals(name)){
                return;
            }
        }
        throw new IllegalArgumentException();// 존재 x
    }

    public String getStationName(){
        return stationName;
    }
}
