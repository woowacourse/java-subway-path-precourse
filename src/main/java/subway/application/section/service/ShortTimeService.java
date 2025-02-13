package subway.application.section.service;

import org.jgrapht.graph.AbstractBaseGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedMultigraph;

import subway.domain.section.Section;
import subway.domain.station.Station;

class ShortTimeService extends ShortCostService {
    private static final AbstractBaseGraph<Station, DefaultWeightedEdge> graph = new DirectedWeightedMultigraph<>(
        DefaultWeightedEdge.class);

    public ShortTimeService() {
        super(graph);
    }

    @Override
    protected double getWeight(Section section) {
        return section.getTime();
    }
}
