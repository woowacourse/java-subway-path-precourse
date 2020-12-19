package subway.domain;

import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import org.junit.jupiter.api.Test;
import subway.InitDataList;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    public LineTest() {
        InitDataList.insertData();
    }

    @Test
    public void edgeTest() throws Exception{
        //given
        List<Line> lines = LineRepository.lines();
        //when
        WeightedMultigraph<Station, DefaultWeightedEdge> graph
                = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        for (Line line : lines) {
            line.addEdge(graph, Weight.DISTANCE);
        }

        //then

        graph.vertexSet().forEach(System.out::println);
    }

}