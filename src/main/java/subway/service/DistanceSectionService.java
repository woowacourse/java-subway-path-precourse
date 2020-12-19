package subway.service;

import java.util.List;
import subway.domain.Distance;
import subway.domain.DistanceSectionRepository;
import subway.domain.Station;
import subway.domain.Time;
import subway.view.PathFindDisplay;
import subway.view.UserInput;

public class DistanceSectionService {

    public static void shortestDistance() {
        Station source = StationService.findStationByName(UserInput.getSourceName());
        Station destination = StationService.findStationByName(UserInput.getDesitnationName());
        List<String> shortestPath = DistanceSectionRepository.getShortestPath(source, destination);
        Distance shortestDistance = SectionService.getDistance(shortestPath);
        Time shortestTime = SectionService.getTime(shortestPath);
        PathFindDisplay.printPathFindResult(shortestDistance, shortestTime, shortestPath);
    }
}
