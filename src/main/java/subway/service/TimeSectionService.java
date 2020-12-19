package subway.service;

import java.util.List;
import subway.domain.Distance;
import subway.domain.Station;
import subway.domain.Time;
import subway.domain.TimeSectionRepository;
import subway.view.PathFindDisplay;
import subway.view.UserInput;

public class TimeSectionService {

    public static void shortestTime() {
        Station source = StationService.findStationByName(UserInput.getSourceName());
        Station destination = StationService.findStationByName(UserInput.getDesitnationName());
        List<String> shortestPath = TimeSectionRepository.getShortestPath(source, destination);
        Distance shortestDistance = SectionService.getDistance(shortestPath);
        Time shortestTime = SectionService.getTime(shortestPath);
        PathFindDisplay.printPathFindResult(shortestDistance, shortestTime, shortestPath);
    }
}
