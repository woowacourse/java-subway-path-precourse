package subway.service.initialization;

import subway.domain.Line;
import subway.domain.Station;
import subway.domain.Stations;
import subway.repository.*;
import subway.type.LineType;
import subway.type.StationType;

public class SubwayInitialization {
    public static void initializeStation() {
        StationRepository.addStation(new Station(StationType.EDUCATION_UNIVERSITY.getStation()));
        StationRepository.addStation(new Station(StationType.GANGNAM.getStation()));
        StationRepository.addStation(new Station(StationType.YEOKSAM.getStation()));
        StationRepository.addStation(new Station(StationType.NAMBU_TERMINAL.getStation()));
        StationRepository.addStation(new Station(StationType.YANGJAE.getStation()));
        StationRepository.addStation(new Station(StationType.YANGJAE_FOREST.getStation()));
        StationRepository.addStation(new Station(StationType.MAEBONG.getStation()));
    }

    public static void initializeLine() {
        LineRepository.addLine(new Line(LineType.TWO.getLine()));
        LineRepository.addLine(new Line(LineType.THREE.getLine()));
        LineRepository.addLine(new Line(LineType.SHINBUNDANG.getLine()));
    }

    public static void initializeStations() {
        StationsRepository.addUpDownStations(new Stations(
                StationType.EDUCATION_UNIVERSITY.getStation(), StationType.GANGNAM.getStation()));
        StationsRepository.addUpDownStations(new Stations(
                StationType.GANGNAM.getStation(), StationType.YEOKSAM.getStation()));
        StationsRepository.addUpDownStations(new Stations(
                StationType.EDUCATION_UNIVERSITY.getStation(), StationType.NAMBU_TERMINAL.getStation()));
        StationsRepository.addUpDownStations(new Stations(
                StationType.NAMBU_TERMINAL.getStation(), StationType.YANGJAE.getStation()));
        StationsRepository.addUpDownStations(new Stations(
                StationType.YANGJAE.getStation(), StationType.MAEBONG.getStation()));
        StationsRepository.addUpDownStations(new Stations(
                StationType.GANGNAM.getStation(), StationType.YANGJAE.getStation()));
        StationsRepository.addUpDownStations(new Stations(
                StationType.YANGJAE.getStation(), StationType.YANGJAE_FOREST.getStation()));
    }

    public static void initializeMaps() {
        DistanceMapInitialization.initializeDistanceMap();
        TimeMapInitialization.initializeTimeMap();
    }
}
