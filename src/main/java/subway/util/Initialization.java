package subway.util;

import subway.Lines;
import subway.Stations;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Initialization {

    public static void set() {
        registerStations();
        registerLines();
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

}
