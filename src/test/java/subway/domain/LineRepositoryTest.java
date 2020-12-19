package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineRepositoryTest {

    @Test
    public void 노선_초기화_테스트(){
        assertThat("2호선").isEqualTo(LineRepository.lines().get(0).getName());
    }

    @Test
    public void 노선_역_초기화_테스트(){
        assertThat("교대역").isEqualTo(LineRepository.lines().get(0)
                .getStations()
                .get(0)
                .getName());
    }

    @Test
    public void 최소시간_테스트(){
        String startStation = "교대역";
        String endStation = "역삼역";
        WeightedMultigraph<String, DefaultWeightedEdge> timeWeight =  LineRepository.getTimeWeight();
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeWeight);
        List<String> shortestPath = dijkstraShortestPath.getPath(startStation, endStation).getVertexList();

        assertThat("교대역").isEqualTo(shortestPath.get(0));

    }

}