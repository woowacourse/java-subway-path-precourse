package subway;

import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.DataInitializer;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.TimeGraph;

import java.util.List;

public class TimeGraphTest {
    static {
        DataInitializer.initialize();
    }

    @DisplayName("최단 경로 출력 테스트")
    @Test
    public void timePathTest() {
        GraphPath<Station, DefaultWeightedEdge> graphPath = TimeGraph.getShortestPath(
                StationRepository.searchByName("교대역"),
                StationRepository.searchByName("양재역")
        );

        List<Station> shortPath = graphPath.getVertexList();
        for (Station station : shortPath) {
            System.out.println(station.getName());
        }

        System.out.println(graphPath.getWeight());
    }
}
