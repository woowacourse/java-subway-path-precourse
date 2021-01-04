package subway.Service;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Line;
import subway.domain.Section;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.SectionRepository;
import subway.repository.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.TextCollection;

import java.util.List;

public class SubwayService {
    private static SubwayService subwayService;

    public static SubwayService getInstance() {
        if (subwayService == null) {
            subwayService = new SubwayService();
        }
        return subwayService;
    }

    public void displayShortestPathInfo(List<String> shortestPath) {
        int distanceSum = 0;
        int timeSum = 0;
        for (int i = 0; i < shortestPath.size() - 1; i++) {
            Section section = SectionRepository.searchSection(shortestPath.get(i), shortestPath.get(i+1));
            distanceSum += section.getDistance();
            timeSum += section.getTime();
        }
        OutputView.printShortestPathInfo(distanceSum, timeSum);
        OutputView.printStations(shortestPath);
    }

    public boolean searchShortestTimePath() {
        OutputView.printQuestion(TextCollection.REGISTER_SOURCE_STATION_MESSAGE);
        Station sourceStation = new Station(InputView.inputValue());
        OutputView.printQuestion(TextCollection.REGISTER_TARGET_STATION_MESSAGE);
        Station targetStation = new Station(InputView.inputValue());
        List<String> shortestPath = getShortestTimePath(sourceStation, targetStation);
        displayShortestPathInfo(shortestPath);
        return true;
    }

    public boolean searchShortestDistancePath() {
        OutputView.printQuestion(TextCollection.REGISTER_SOURCE_STATION_MESSAGE);
        Station sourceStation = new Station(InputView.inputValue());
        OutputView.printQuestion(TextCollection.REGISTER_TARGET_STATION_MESSAGE);
        Station targetStation = new Station(InputView.inputValue());
        List<String> shortestPath = getShortestDistancePath(sourceStation, targetStation);
        displayShortestPathInfo(shortestPath);
        return true;
    }

    public boolean backup() {
        return true;
    }

    public List<String> getShortestTimePath(Station sourceStation, Station targetStation) {
        DijkstraShortestPath dijkstraShortestPath = getDijkstraShortestTimePath();
        List<String> shortestPath = dijkstraShortestPath.getPath(sourceStation.getName(), targetStation.getName()).getVertexList();
        return shortestPath;
    }

    public List<String> getShortestDistancePath(Station sourceStation, Station targetStation) {
        DijkstraShortestPath dijkstraShortestPath = getDijkstraShortestDistancePath();
        List<String> shortestPath = dijkstraShortestPath.getPath(sourceStation.getName(), targetStation.getName()).getVertexList();
        return shortestPath;
    }

    public DijkstraShortestPath getDijkstraShortestTimePath() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);

        StationRepository.stations().forEach(station -> graph.addVertex(station.getName()));

        for (Line line : LineRepository.lines()) {
            line.getSections()
                    .forEach(section -> graph.setEdgeWeight(
                            graph.addEdge(section.getSourceStationName(), section.getTargetStationName()),
                            section.getTime()));
        }
        return new DijkstraShortestPath(graph);
    }

    public DijkstraShortestPath getDijkstraShortestDistancePath() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        StationRepository.stations().forEach(station -> graph.addVertex(station.getName()));
        for (Line line : LineRepository.lines()) {
            line.getSections()
                    .forEach(section -> graph.setEdgeWeight(
                            graph.addEdge(section.getSourceStationName(), section.getTargetStationName()),
                            section.getDistance()));
        }
        return new DijkstraShortestPath(graph);
    }
}
