package subway.util;

import subway.graph.DistanceWeightedGraph;
import subway.graph.TimeWeightedGraph;
import subway.legacy.Lines;
import subway.legacy.Stations;
import subway.domain.*;

public class Initialization {

    public static void set() {
        registerStations();
        registerLines();
        registerConnections();
        setGraph();
    }

    private static void registerStations() {
        StationRepository.addStation(new Station(Stations.GYODAE.getName()));
        StationRepository.addStation(new Station(Stations.GANGNAM.getName()));
        StationRepository.addStation(new Station(Stations.YEOKSAM.getName()));
        StationRepository.addStation(new Station(Stations.NAMBU_BUS_TERMINAL.getName()));
        StationRepository.addStation(new Station(Stations.YANGJAE.getName()));
        StationRepository.addStation(new Station(Stations.YANGJAE_CITIZEN_FOREST.getName()));
        StationRepository.addStation(new Station(Stations.MAEBONG.getName()));
    }

    private static void registerLines() {
        LineRepository.addLine(new Line(Lines.LINE_2.getName()));
        LineRepository.addLine(new Line(Lines.LINE_3.getName()));
        LineRepository.addLine(new Line(Lines.LINE_SHINBUNDANG.getName()));
    }

    private static void registerConnections() {
        ConnectionRepository.addConnection(new Connection(Stations.GYODAE.getName(), Stations.GANGNAM.getName(), 2, 3));
        ConnectionRepository.addConnection(new Connection(Stations.GANGNAM.getName(), Stations.YEOKSAM.getName(), 2, 3));
        ConnectionRepository.addConnection(new Connection(Stations.GYODAE.getName(), Stations.NAMBU_BUS_TERMINAL.getName(), 3,2));
        ConnectionRepository.addConnection(new Connection(Stations.NAMBU_BUS_TERMINAL.getName(), Stations.YANGJAE.getName(), 6,5));
        ConnectionRepository.addConnection(new Connection(Stations.YANGJAE.getName(), Stations.MAEBONG.getName(), 1,1));
        ConnectionRepository.addConnection(new Connection(Stations.GANGNAM.getName(), Stations.YANGJAE.getName(), 2,8));
        ConnectionRepository.addConnection(new Connection(Stations.YANGJAE.getName(), Stations.YANGJAE_CITIZEN_FOREST.getName(), 10,3));
    }

    private static void setGraph() {
        for (Station station : StationRepository.stations()) {
            DistanceWeightedGraph.addVertex(station.getName());
            TimeWeightedGraph.addVertex(station.getName());
        }
        for (Connection connection : ConnectionRepository.connections()) {
            DistanceWeightedGraph.setEdgeWeight(DistanceWeightedGraph.addEdge(connection.getSource(), connection.getDestination()), connection.getDistance());
            TimeWeightedGraph.setEdgeWeight(TimeWeightedGraph.addEdge(connection.getSource(), connection.getDestination()), connection.getTime());
        }
    }

}