package subway.service;

import subway.domain.Station;
import subway.repository.StationRepository;
import subway.repository.SubwayRepository;
import subway.util.exception.SameStationException;

import static subway.util.message.ExceptionMessage.SAME_AS;

public class SubwayService {
    private final SubwayRepository subwayRepository = SubwayRepository.getInstance();
    private final StationRepository stationRepository = StationRepository.getInstance();

    public void initSubway(){
        subwayRepository.initSubway();
    }

    public void getShortestDistance(final String startStationInfo, final String endStationInfo){
        Station startStation = stationRepository.findByName(startStationInfo);
        Station endStation = stationRepository.findByName(endStationInfo);
        isSameStation(startStation, endStation);
    }

    private void isSameStation(final Station start, final Station end){
        throw new SameStationException(SAME_AS.getValue());
    }
}
