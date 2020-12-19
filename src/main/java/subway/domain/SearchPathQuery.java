package subway.domain;

import subway.domain.exception.DuplicatedStationException;
import subway.domain.exception.NullStationException;
import subway.domain.station.StationRepository;
import subway.domain.weight.WeightType;

public class SearchPathQuery {
    private WeightType weightType;
    private String startStation;
    private String endStation;

    public SearchPathQuery(WeightType weightType, String startStation, String endStation) {
        if (!StationRepository.containsStation(startStation)) {
            throw new NullStationException(startStation);
        }

        if (!StationRepository.containsStation(endStation)) {
            throw new NullStationException(endStation);
        }

        if (startStation.equals(endStation)) {
            throw new DuplicatedStationException();
        }

        this.weightType = weightType;
        this.startStation = startStation;
        this.endStation = endStation;
    }
}
