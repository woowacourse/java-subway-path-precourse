package subway.domain;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import org.junit.jupiter.api.Test;

class LineStationTest {

    @Test
    public void 구간_정보를_등록한다() throws Exception {
        //given
        WeightedMultigraph<Station, DefaultWeightedEdge> lineStation
                = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        Station s1 = new Station("강남역");
        Station s2 = new Station("양재역");
        Station s3 = new Station("홍대역");

        lineStation.addVertex(s1);
        lineStation.addVertex(s2);
        lineStation.addVertex(s3);
        lineStation.setEdgeWeight(lineStation.addEdge(s1,s2), 2);
        lineStation.setEdgeWeight(lineStation.addEdge(s2,s3), 2);
        lineStation.setEdgeWeight(lineStation.addEdge(s1,s3), 100);

        //when
        DijkstraShortestPath result = new DijkstraShortestPath(lineStation);
        GraphPath path = result.getPath(s1, s3);
        System.out.println(path.getWeight());
        //then
        for (Object station : path.getEdgeList()) {
            System.out.println(station.toString());
        }
        System.out.println(path.toString());
    }
}