package subway.domain.Path.dto;

import java.util.List;
import subway.domain.station.dto.StationResponseDto;

public class PathResponseDto {

    final List<StationResponseDto> stations;
    final double totalWeight;

    public PathResponseDto(List<StationResponseDto> stations, double totalWeight) {
        this.stations = stations;
        this.totalWeight = totalWeight;
    }

    public List<StationResponseDto> getStations() {
        return stations;
    }

    public double getTotalWeight() {
        return totalWeight;
    }
}
