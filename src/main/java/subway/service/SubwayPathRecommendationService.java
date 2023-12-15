package subway.service;

import subway.domain.Station;
import subway.domain.StationIntervalInfo;
import subway.domain.StationRepository;

public class SubwayPathRecommendationService {

    public void recommend(String standardCode, String start, String end) {
        StationIntervalInfo stationIntervalInfo = new StationIntervalInfo(standardCode);

        Station startStation = StationRepository.findByName(start);
        Station endStation = StationRepository.findByName(end);
    }
}
