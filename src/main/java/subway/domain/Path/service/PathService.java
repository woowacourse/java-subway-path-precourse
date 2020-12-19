package subway.domain.Path.service;

import org.jgrapht.GraphPath;
import subway.domain.Path.domain.PathRepository;
import subway.domain.Path.domain.WeightGraph;
import subway.domain.Path.dto.PathResponseDto;
import subway.domain.Path.exception.NotConnectedException;
import subway.domain.Path.exception.SameStartAndEndStationException;
import subway.domain.station.domain.Station;
import subway.domain.station.domain.StationRepository;

public class PathService {

    public static PathResponseDto getShortestDistanceGraphPath(String sourceStationName,
        String targetStationName) {
        return getShortestRoute(PathRepository.getTimeWeightGraph(), sourceStationName,
            targetStationName);
    }

    public static PathResponseDto getShortestTimeGraphPath(String sourceStationName,
        String targetStationName) {
        return getShortestRoute(PathRepository.getDistanceWeightGraph(), sourceStationName,
            targetStationName);
    }

    private static PathResponseDto getShortestRoute(WeightGraph weightGraph,
        String sourceStationName, String targetStationName) {
        if (sourceStationName.equals(targetStationName)) {
            throw new SameStartAndEndStationException(sourceStationName, targetStationName);
        }

        Station sourceStation = StationRepository.findByName(sourceStationName);
        Station targetStation = StationRepository.findByName(targetStationName);

        try {
            GraphPath graphPath = weightGraph.getDijkstraShortestPath()
                .getPath(sourceStation, targetStation);
            return new PathResponseDto(graphPath.getEdgeList(), graphPath.getWeight());
        } catch (IllegalArgumentException e) {
            throw new NotConnectedException(sourceStationName, targetStationName);
        }
    }
}
