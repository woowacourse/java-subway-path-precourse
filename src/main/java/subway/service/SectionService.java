package subway.service;

import java.util.List;
import subway.domain.Distance;
import subway.domain.SectionRepository;
import subway.domain.Time;

public class SectionService {

    public static Distance getDistance(List<String> shortestPath) {
        return SectionRepository.getDistance(shortestPath);
    }

    public static Time getTime(List<String> shortestPath) {
        return SectionRepository.getTime(shortestPath);
    }
}
