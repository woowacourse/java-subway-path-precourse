package subway.util;

import subway.legacy.Lines;
import subway.legacy.Stations;
import subway.domain.*;

public class Initialization {

    public static void set() {
        registerStations();
        registerLines();
        registerConnections();
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
        Connections.addConnection(new Connection(Stations.GYODAE.getName(), Stations.GANGNAM.getName(), 2, 3));
        Connections.addConnection(new Connection(Stations.GANGNAM.getName(), Stations.YEOKSAM.getName(), 2, 3));
        Connections.addConnection(new Connection(Stations.GYODAE.getName(), Stations.NAMBU_BUS_TERMINAL.getName(), 3,2));
        Connections.addConnection(new Connection(Stations.NAMBU_BUS_TERMINAL.getName(), Stations.YANGJAE.getName(), 6,5));
        Connections.addConnection(new Connection(Stations.YANGJAE.getName(), Stations.MAEBONG.getName(), 1,1));
        Connections.addConnection(new Connection(Stations.GANGNAM.getName(), Stations.YANGJAE.getName(), 2,8));
        Connections.addConnection(new Connection(Stations.YANGJAE.getName(), Stations.YANGJAE_CITIZEN_FOREST.getName(), 10,3));
    }

}