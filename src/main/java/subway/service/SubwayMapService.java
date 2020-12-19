package subway.service;

import subway.domain.SubwayMap;
import subway.domain.SubwayPath;
import subway.repository.SubwayMapRepository;

import java.util.List;

public class SubwayMapService {
    public static void addMap(String lineName, List<SubwayPath> subwayPaths) {
        SubwayMap subwayMap = new SubwayMap(lineName, subwayPaths);
        SubwayMapRepository.addMap(subwayMap);
    }
}
