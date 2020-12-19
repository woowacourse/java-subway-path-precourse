package subway;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import org.junit.jupiter.api.Test;

import java.util.List;
import subway.domain.section.Section;
import subway.domain.section.Time;
import subway.domain.station.Station;
import subway.repository.SectionRepository;
import subway.repository.StationRepository;

import static org.assertj.core.api.Assertions.assertThat;

public class JGraphtTest {

    @Test
    public void getDijkstraShortestPath() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(
            DefaultWeightedEdge.class);
        graph.addVertex("v1");
        graph.addVertex("v2");
        graph.addVertex("v3");
        graph.setEdgeWeight(graph.addEdge("v1", "v2"), 2);
        graph.setEdgeWeight(graph.addEdge("v2", "v3"), 2);
        graph.setEdgeWeight(graph.addEdge("v1", "v3"), 100);

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath("v3", "v1").getVertexList();

        assertThat(shortestPath.size()).isEqualTo(3);
    }

    @Test
    public void noNameTest() {

        WeightedMultigraph<Station, Double> graph = new WeightedMultigraph(
            DefaultWeightedEdge.class);

        SectionRepository repository = new SectionRepository();
        List<Section> sections = repository.findAll();
        System.out.println(sections.size());

        StationRepository stationRepository = new StationRepository();

        List<Station> stations = stationRepository.stations();

        System.out.println(stations.size());
        System.out.println(sections.size());

        for (Station station : stations) {
            graph.addVertex(station);
        }
        // graph.setEdgeWeight(graph.addEdge("v1", "v2"), 2);
        for (Section section : sections) {
            graph.setEdgeWeight(graph.addEdge(section.getNextStation(), section.getPreStation()),
                section.getTime());
        }

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);

        Station form = stationRepository.findByName("교대역");
        Station to = stationRepository.findByName("강남역");

        List result = dijkstraShortestPath.getPath(form, to).getEdgeList();
        System.out.println(result.size());


    }

}
