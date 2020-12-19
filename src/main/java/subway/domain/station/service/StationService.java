package subway.domain.station.service;

import subway.domain.station.domain.Station;
import subway.domain.station.domain.StationRepository;
import subway.domain.station.dto.StationRequestDto;

public class StationService {

    public static void save(StationRequestDto requestDto) {
        Station newStation = Station.from(requestDto.getName());
        StationRepository.save(newStation);
    }
}
