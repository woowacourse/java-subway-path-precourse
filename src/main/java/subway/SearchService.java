package subway;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.domain.station.StationService;
import subway.exception.ErrorCode;
import subway.exception.SectionException;
import subway.exception.StationException;
import subway.view.InputView;
import subway.view.screen.SearchView;

import java.util.ArrayList;
import java.util.List;

public class SearchService {
    private static final List<DijkstraShortestPath> dijkstraShortestPaths = new ArrayList<>();
    private static final int DISTANCE_INDEX = 0;
    private static final int TIME_INDEX = 1;

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


    }
    private void checkSameName(String firstStationName, String downwardStationName) {
        if (firstStationName.equals(downwardStationName)) {
            throw new StationException(ErrorCode.SECTION_SAME_STATION_NAME);
        }
    }
}
