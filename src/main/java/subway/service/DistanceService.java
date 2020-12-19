package subway.service;

import subway.domain.*;
import subway.dto.MinimumDistanceResultDto;
import subway.exception.DuplicatedStartAndEndException;

import java.util.List;

public class DistanceService {
    private static Graph graph = new Graph();

    public static void addDistance(Station station1, Station station2, int physicalDistance, int timeDistance) {
        Distance distanceToAdd = new Distance(station1, station2, physicalDistance, timeDistance);
        DistanceRepository.addDistance(distanceToAdd);
        graph.addNoteWithDistance(distanceToAdd);
    }

    public static MinimumDistanceResultDto getShortestPhysicalDistanceResult(Station stationBegin, Station stationEnd) {
        if(stationBegin.equals(stationEnd)) {
            throw new DuplicatedStartAndEndException();
        }
        List<Station> stationList = graph.getMinimumTimeDistanceBetweenStations(stationBegin, stationEnd);
        int physicalDistance = DistanceRepository.getPhysicalDistance(stationList);
        int timeDistance = DistanceRepository.getTimeDistance(stationList);
        MinimumDistanceResultDto minimumDistanceResultDto =
                new MinimumDistanceResultDto(stationList, physicalDistance, timeDistance);
        return minimumDistanceResultDto;
    }

    public static MinimumDistanceResultDto getShortestTimeDistanceResult(Station stationBegin, Station stationEnd) {
        if(stationBegin.equals(stationEnd)) {
            throw new DuplicatedStartAndEndException();
        }
        List<Station> stationList = graph.getMinimumTimeDistanceBetweenStations(stationBegin, stationEnd);
        int physicalDistance = DistanceRepository.getPhysicalDistance(stationList);
        int timeDistance = DistanceRepository.getTimeDistance(stationList);
        MinimumDistanceResultDto minimumDistanceResultDto =
                new MinimumDistanceResultDto(stationList, physicalDistance, timeDistance);
        return minimumDistanceResultDto;
    }
}
