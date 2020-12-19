package subway.domain.station;

import subway.domain.station.dto.StationSaveReqDto;
import subway.exception.ErrorCode;
import subway.exception.StationException;

public class StationService {
    public StationService() {
    }

    public Station saveStation(StationSaveReqDto saveReqDto) {
        try {
            StationRepository.findByName(saveReqDto.getStationName());
        } catch (StationException stationException) {
            Station station = new Station(saveReqDto.getStationName());
            StationRepository.addStation(station);
            return station;
        }
        throw new StationException(ErrorCode.STATION_ALREADY_EXIST);
    }

    public void removeAll() {
        StationRepository.deleteAll();
    }
}
