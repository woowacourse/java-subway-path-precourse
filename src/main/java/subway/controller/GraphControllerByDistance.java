package subway.controller;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.Arrays;
import java.util.List;

public class GraphController {
    private static final String KYODAE = "교대역";
    private static final String GANGNAM = "강남역";
    private static final String YUKSAM = "역삼역";
    private static final String NAMBU = "남부터미널역";
    private static final String YANGJAE = "양재역";
    private static final String YANGJAEFOREST = "양재시민의숲역";
    private static final String MAEBONG = "매봉역";

    private List<String> stations = Arrays.asList(KYODAE, GANGNAM, YUKSAM, NAMBU,
            YANGJAE, YANGJAEFOREST, MAEBONG);
    private List<String> line2 = Arrays.asList(KYODAE, GANGNAM, YUKSAM);
    private List<String> line3 = Arrays.asList(KYODAE, NAMBU, YANGJAE, MAEBONG);
    private List<String> lineShin = Arrays.asList(GANGNAM, YANGJAE, YANGJAEFOREST);

    public void init() {
        initByDistance();
        initByTime();
    }

    private void initByDistance() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph
                = new WeightedMultigraph(DefaultWeightedEdge.class);
        stations.forEach(station -> graph.addVertex(station));
        for (int i = 0; i < line2.size()-1; i++) {
            line2[i]
        }

    }

    private void initByTime() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph
                = new WeightedMultigraph(DefaultWeightedEdge.class);
        stations.forEach(station -> graph.addVertex(station));
    }
}
