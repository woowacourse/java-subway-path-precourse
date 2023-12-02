package subway.service;

import subway.domain.ConnectStationNode;
import subway.domain.Station;
import subway.repository.GraphRepository;
import subway.repository.StationRepository;
import subway.util.exception.NotConnectException;
import subway.util.exception.SameStationException;
import subway.util.message.InputMessage;
import subway.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static subway.util.message.ExceptionMessage.NO_CONNECT_AS_STATION;
import static subway.util.message.ExceptionMessage.SAME_AS;

public class GraphService {
    private final GraphRepository graphRepository = GraphRepository.getInstance();
    private final StationRepository stationRepository = StationRepository.getInstance();
    private static final int ZERO = 0;
    private static final int NEGATIVE = -1;
    private static final int ONE = 1;
    private int totalDistance;
    private int totalTime;

    public void initGraph(){
        init();
        graphRepository.initGraph();
    }

    private void init(){
        totalDistance = ZERO;
        totalTime = ZERO;
    }

    private List<Station> isSameStation(final String startStationInfo, final String endStationInfo){
        Station startStation = stationRepository.findByName(startStationInfo);
        Station endStation = stationRepository.findByName(endStationInfo);
        if(startStation.isEqualName(endStationInfo)){
            throw new SameStationException(SAME_AS.getValue());
        }
        return addCompareTwoTarget(startStation, endStation);
    }

    private List<Station> addCompareTwoTarget(Station start, Station end){
        return new ArrayList<>(List.of(start, end));
    }

    public List<String> getShortestDistancePath(final String startStationInfo, final String endStationInfo){
        List<Station> stations = isSameStation(startStationInfo, endStationInfo);
        return graphRepository.getShortestDistance(stations.get(0), stations.get(1));
    }

    public List<String> getShortestTimePath(final String startStationInfo, final String endStationInfo){
        List<Station> stations = isSameStation(startStationInfo, endStationInfo);
        return graphRepository.getShortestTime(stations.get(0), stations.get(1));
    }

    public List<Integer> getTotalShortestDistanceAndShortestTime(final List<String> path){
        for(int target = 0; target < path.size() - 1; target++){
            Station startStation = stationRepository.findByName(path.get(target));
            Station nextStation = stationRepository.findByName(path.get(target + 1));
            int[] data = getTargetDistanceAndTime(startStation, nextStation);
            totalDistance += data[ZERO];
            totalTime += data[ONE];
        }
        return new ArrayList(List.of(totalDistance, totalTime));
    }

    private int[] getTargetDistanceAndTime(final Station startStation, final Station nexStation){
        int[] data = getDistanceAndTimeAccessConnectData(startStation, nexStation);
        if (data[ZERO] == NEGATIVE) {
            data = getDistanceAndTimeAccessConnectData(nexStation, startStation);
        }
        return data;
    }

    private int[] getDistanceAndTimeAccessConnectData(final Station startStation, final Station nexStation){
        int[] data = {NEGATIVE, NEGATIVE};
        for (ConnectStationNode connectData : startStation.getConnectStationNodes()) {
            if (connectData.getStation().isEqualName(nexStation.getName())) {
                data[ZERO] = connectData.getDistance();
                data[ONE] = connectData.getTime();
            }
        }
        return data;
    }
}
