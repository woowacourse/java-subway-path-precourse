package subway.application.section.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.AbstractBaseGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import subway.domain.section.Section;
import subway.domain.station.Station;

abstract class ShortCostService {
    private final AbstractBaseGraph<Station, DefaultWeightedEdge> graph;

    public ShortCostService(AbstractBaseGraph<Station, DefaultWeightedEdge> graph) {
        this.graph = graph;
    }

    private static final String ALREADY_EXISTS_NODE_MESSAGE = "이미 등록되어있는 노드입니다.";
    private static final String NOT_EXISTS_SOURCE_NODE_MESSAGE = "존재하지 않은 시작노드입니다.";
    private static final String NOT_EXISTS_SINK_NODE_MESSAGE = "존재하지 않은 종료노드입니다.";
    private static final String ALREADY_EXISTS_EDGE_MESSAGE = "이미 등록되어있는 간선입니다.";

    protected Set<Station> findAllNode() {
        return Collections.unmodifiableSet(graph.vertexSet());
    }

    protected Set<DefaultWeightedEdge> findAllEdge() {
        return Collections.unmodifiableSet(graph.edgeSet());
    }

    protected void addNode(Station station) {
        if (graph.containsVertex(station)) {
            throw new IllegalArgumentException(ALREADY_EXISTS_NODE_MESSAGE);
        }
        graph.addVertex(station);
    }

    protected void addEdge(Section section) {
        Station source = section.getSource();
        Station sink = section.getSink();
        this.validateSource(source);
        this.validateSink(sink);
        if (graph.containsEdge(source, sink)) {
            throw new IllegalArgumentException(ALREADY_EXISTS_EDGE_MESSAGE);
        }
        graph.setEdgeWeight(graph.addEdge(source, sink), this.getWeight(section));
    }

    protected abstract double getWeight(Section section);

    protected GraphPath<Station, DefaultWeightedEdge> compute(Station source, Station sink) {
        this.validateSource(source);
        this.validateSink(sink);
        DijkstraShortestPath<Station, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(graph);
        return dijkstraShortestPath.getPath(source, sink);
    }

    protected void validateSource(Station source) {
        if (!graph.containsVertex(source)) {
            throw new IllegalArgumentException(NOT_EXISTS_SOURCE_NODE_MESSAGE);
        }
    }

    protected void validateSink(Station sink) {
        if (!graph.containsVertex(sink)) {
            throw new IllegalArgumentException(NOT_EXISTS_SINK_NODE_MESSAGE);
        }
    }

    protected void deleteAllNode() {
        Set<Station> nodes = new HashSet<>(this.findAllNode());
        graph.removeAllVertices(nodes);
    }

    protected void deleteAllEdge() {
        graph.removeAllEdges(graph.edgeSet());
    }

    protected void deleteAll() {
        this.deleteAllEdge();
        this.deleteAllNode();
    }
}
