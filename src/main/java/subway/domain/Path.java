package subway.domain;

import java.util.List;

public class Path {
    private Line line;
    private List<Station> stationList;
    private PathDistanceWeight pathDistanceWeight;



    public Path(Line line, List<Station> stations, List<Integer> distance, List<Integer> time){
        this.line = line;
        registerStation(stations);
        this.pathDistanceWeight = new PathDistanceWeight(stations, distance);

    }

    private void registerStation(List<Station> stations){
        for(Station station : stations){
            stationList.add(station);
        }
    }



}
