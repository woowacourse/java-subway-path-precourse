package subway.repository;

import subway.domain.ConnectStationNode;
import subway.domain.Station;
import subway.util.constants.StationName;
import subway.util.exception.NoResourceException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static subway.util.message.ExceptionMessage.NO_RESOURCE_MESSAGE;

public class StationRepository {

    private static final StationRepository stationRepository = new StationRepository();
    private StationRepository(){

    }

    public static StationRepository getInstance(){
        return stationRepository;
    }

    public void initStation(){
        for (StationName stationName : StationName.values()) {
            Station station = Station.create(stationName.getKey());
            addStation(station);
        }
    }
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }

    public Station findByName(String name){
        return stations.stream()
                .filter(station -> station.isEqualName(name))
                .findFirst()
                .orElseThrow(() -> new NoResourceException(String.format(NO_RESOURCE_MESSAGE.getValue(), "해당 역")));
    }

    public void initConnectInfo(String start, String end, int distance, int time){
        Station startStation = findByName(start);
        Station endStation = findByName(end);
        ConnectStationNode connectStationNode = ConnectStationNode.create(endStation, distance, time);
        startStation.addConnectStations(connectStationNode);
    }
}
