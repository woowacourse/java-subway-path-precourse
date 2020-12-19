package subway.domain;

import java.util.Collection;
import java.util.Set;
import java.util.function.Supplier;
import org.jgrapht.Graph;
import org.jgrapht.GraphType;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

public class DefaultSubwayGraph implements Graph<String, Section> {

    private static DefaultDirectedWeightedGraph subwayMap;
    private static DefaultSections defaultSections;

    public static void DefaultSubwayGraph() {
        subwayMap = new DefaultDirectedWeightedGraph<Station, DefaultWeightedEdge>(
            DefaultWeightedEdge.class);
        defaultSections = new DefaultSections();
        addDefaultStations();
        addDefaultEdges();
    }

    public static void addDefaultStations() {
        for (Station station : DefaultStations.getDefaultStations()) {
            subwayMap.addVertex(station.getName());
        }
    }

    public static void addDefaultEdges() {
        for (Section section : DefaultSections.getSections()) {
            DefaultWeightedEdge e = (DefaultWeightedEdge) subwayMap
                .addEdge(section.getDepartureStation(), section.getArrivalStation());
            subwayMap.setEdgeWeight(e, section.getCost().getDistanceCost());
        }
    }

    @Override
    public Set<Section> getAllEdges(String sourceVertex, String targetVertex) {
        return null;
    }

    @Override
    public Section getEdge(String sourceVertex, String targetVertex) {
        return null;
    }

    @Override
    public Supplier<String> getVertexSupplier() {
        return null;
    }

    @Override
    public Supplier<Section> getEdgeSupplier() {
        return null;
    }

    @Override
    public Section addEdge(String sourceVertex, String targetVertex) {
        return null;
    }

    @Override
    public boolean addEdge(String sourceVertex, String targetVertex, Section section) {
        return false;
    }

    @Override
    public String addVertex() {
        return null;
    }

    @Override
    public boolean addVertex(String s) {
        return false;
    }

    @Override
    public boolean containsEdge(String sourceVertex, String targetVertex) {
        return false;
    }

    @Override
    public boolean containsEdge(Section section) {
        return false;
    }

    @Override
    public boolean containsVertex(String s) {
        return false;
    }

    @Override
    public Set<Section> edgeSet() {
        return null;
    }

    @Override
    public int degreeOf(String vertex) {
        return 0;
    }

    @Override
    public Set<Section> edgesOf(String vertex) {
        return null;
    }

    @Override
    public int inDegreeOf(String vertex) {
        return 0;
    }

    @Override
    public Set<Section> incomingEdgesOf(String vertex) {
        return null;
    }

    @Override
    public int outDegreeOf(String vertex) {
        return 0;
    }

    @Override
    public Set<Section> outgoingEdgesOf(String vertex) {
        return null;
    }

    @Override
    public boolean removeAllEdges(Collection<? extends Section> edges) {
        return false;
    }

    @Override
    public Set<Section> removeAllEdges(String sourceVertex, String targetVertex) {
        return null;
    }

    @Override
    public boolean removeAllVertices(Collection<? extends String> vertices) {
        return false;
    }

    @Override
    public Section removeEdge(String sourceVertex, String targetVertex) {
        return null;
    }

    @Override
    public boolean removeEdge(Section section) {
        return false;
    }

    @Override
    public boolean removeVertex(String s) {
        return false;
    }

    @Override
    public Set<String> vertexSet() {
        return null;
    }

    @Override
    public String getEdgeSource(Section section) {
        return null;
    }

    @Override
    public String getEdgeTarget(Section section) {
        return null;
    }

    @Override
    public GraphType getType() {
        return null;
    }

    @Override
    public double getEdgeWeight(Section section) {
        return 0;
    }

    @Override
    public void setEdgeWeight(Section section, double weight) {

    }
}
