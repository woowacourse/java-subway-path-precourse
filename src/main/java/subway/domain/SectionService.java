package subway.domain;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.error.SameNameException;
import subway.model.ResultDto;
import subway.view.OutputView;

public class SectionService {

    public static ResultDto findShortestPath(String startStationName, String endStationName) {
        checkSameStationName(startStationName, endStationName);
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(SectionRepository.getDistanceGraph());

        List<Station> path = dijkstraShortestPath.getPath(StationRepository.findByName(startStationName), StationRepository.findByName(endStationName))
            .getVertexList();

        int totalDistance = 0;
        int totalTime = 0;
        for (int i = 0; i < path.size()-1; i++) {
            try {
                Section section = SectionRepository.findByStartAndEndStation(path.get(i), path.get(i+1));
                totalDistance += section.getDistance();
                totalTime += section.getTime();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return new ResultDto(totalDistance, totalTime, path);
    }

    private static void checkSameStationName(String startStationName, String endStationName) {
        if (startStationName.equals(endStationName)) {
            throw new SameNameException();
        }
    }
}
