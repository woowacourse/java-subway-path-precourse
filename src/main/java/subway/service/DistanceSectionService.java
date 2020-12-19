package subway.service;

import java.util.List;
import subway.domain.DistanceSectionRepository;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.view.UserInput;

public class DistanceSectionService {

    public static void shortestDistance() {
        Station source = StationService.findStationByName(UserInput.getSourceName());
        Station destination = StationService.findStationByName(UserInput.getDesitnationName());
        List<String> shortestPath = DistanceSectionRepository.getShortestPath(source, destination);
        SectionRepository.getDistance();
    }
}
