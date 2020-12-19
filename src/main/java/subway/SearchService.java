package subway;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.exception.ErrorCode;
import subway.exception.StationException;
import subway.view.InputView;
import subway.view.screen.SearchView;

import java.util.ArrayList;
import java.util.List;

public class SearchService {
    private static final List<DijkstraShortestPath> dijkstraShortestPaths = new ArrayList<>();
    private static final int DISTANCE_INDEX = 1;
    private static final int TIME_INDEX = 0;

    private final InputView inputView;
    private final SearchView searchView;

    public SearchService(InputView inputView, SearchView searchView) {
        this.inputView = inputView;
        this.searchView = searchView;
    }

    public static void addDijkstraShortestPath(DijkstraShortestPath dijkstraShortestPath) {
        dijkstraShortestPaths.add(dijkstraShortestPath);
    }

    public void findShortestDistance() {
        searchView.printAdd();
        String firstStationName = inputView.inputNextLine();
        Station firstStation = StationRepository.findByName(firstStationName);

        searchView.printSecondAdd();
        String secondStationName = inputView.inputNextLine();
        Station secondStation = StationRepository.findByName(secondStationName);
        checkSameName(firstStationName, secondStationName);

        searchView.printAfterAdd();
        printDistance(firstStation, secondStation);
    }

    public void findShortestTime() {
        searchView.printAdd();
        String firstStationName = inputView.inputNextLine();
        Station firstStation = StationRepository.findByName(firstStationName);

        searchView.printSecondAdd();
        String secondStationName = inputView.inputNextLine();
        Station secondStation = StationRepository.findByName(secondStationName);
        checkSameName(firstStationName, secondStationName);

        searchView.printAfterAdd();
        printTime(firstStation, secondStation);
    }

    private void printTime(Station firstStation, Station secondStation) {
        DijkstraShortestPath dijkstraShortestPathDistance = dijkstraShortestPaths.get(DISTANCE_INDEX);
        double pathWeight = dijkstraShortestPathDistance.getPathWeight(firstStation.getName(), secondStation.getName());
        GraphPath path = dijkstraShortestPathDistance.getPath(firstStation.getName(), secondStation.getName());
        searchView.printList(path, pathWeight);
    }

    private void printDistance(Station firstStation, Station secondStation) {
        DijkstraShortestPath dijkstraShortestPathDistance = dijkstraShortestPaths.get(TIME_INDEX);
        double pathWeight = dijkstraShortestPathDistance.getPathWeight(firstStation.getName(), secondStation.getName());
        GraphPath path = dijkstraShortestPathDistance.getPath(firstStation.getName(), secondStation.getName());
        searchView.printList(path, pathWeight);
    }

    private void checkSameName(String firstStationName, String secondStationName) {
        if (firstStationName.equals(secondStationName)) {
            throw new StationException(ErrorCode.STATION_SAME_NAME);
        }
    }

}
