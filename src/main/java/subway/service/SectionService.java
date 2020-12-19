package subway.service;

import java.util.List;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;

public class SectionService {

    public static int getTotalTime(List<Station> stationList) {
        int totalTime = 0;
        for (int i = 0; i < stationList.size() - 1; i++) {
            Section section = SectionRepository
                .findByStation(stationList.get(i), stationList.get(i + 1));
            totalTime += section.getTime();
        }
        return totalTime;
    }

    public static int getTotalDistance(List<Station> stationList) {
        int totalDistance = 0;
        for (int i = 0; i < stationList.size() - 1; i++) {
            Section section = SectionRepository
                .findByStation(stationList.get(i), stationList.get(i + 1));
            totalDistance += section.getDistance();
        }
        return totalDistance;
    }

}
