package subway.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Section;
import subway.domain.Station;
import subway.domain.StationGraph;
import subway.domain.StationRepository;

public class SubwayPathControllerInitializer {
    private static final int GYODAE_GANGNAM_DISTANCE = 2;
    private static final int GYODAE_GANGNAM_TIME = 3;
    private static final int GYODAE_SOUTH_TERMINAL_DISTANCE = 3;
    private static final int GYODAE_SOUTH_TERMINAL_TIME = 2;
    private static final int GANGNAM_YEOKSAM_DISTANCE = 2;
    private static final int GANGNAM_YEOKSAM_TIME = 3;
    private static final int GANGNAM_YANGJAE_DISTANCE = 2;
    private static final int GANGNAM_YANGJAE_TIME = 8;
    private static final int SOUTH_TERMINAL_YANGJAE_DISTANCE = 6;
    private static final int SOUTH_TERMINAL_YANGJAE_TIME = 5;
    private static final int YANGJAE_MAEBONG_DISTANCE = 1;
    private static final int YANGJAE_MAEBONG_TIME = 1;
    private static final int YANGJAE_YANGJAE_FOREST_DISTANCE = 10;
    private static final int YANGJAE_YANGJAE_FOREST_TIME = 3;

    private static final List<String> DEFAULT_STATION_LINES_DATA = Arrays.asList("2호선", "3호선", "신분당선");
    private StationGraph stationGraph;

    public SubwayPathControllerInitializer(StationGraph stationGraph) {
        this.stationGraph = stationGraph;
    }

    public void initDefaultStationName() {
        Init.initList.stream().map(Init::getStationName).map(Station::new).forEach(StationRepository::addStation);
    }

    public void initDefaultStationLine() {
        DEFAULT_STATION_LINES_DATA.stream().map(Line::new).forEach(LineRepository::addLine);
    }

    public void makeInitDefaultStationSection() {
        List<List<Section>> stationDistanceList = stationGraph.getStationDistanceGraph();
        for (int i = 0; i < Init.initList.size(); i++) {
            stationDistanceList.add(new ArrayList<>());
        }
        addInitDefaultStationSection(stationDistanceList);
        addInitDefaultStationSectionReverse(stationDistanceList);
    }

    private void addInitDefaultStationSection(List<List<Section>> stationDistanceList) {
        stationDistanceList.get(Init.GYODAE.getStaionNumber())
                .add(new Section(Init.GANGNAM.getStaionNumber(), GYODAE_GANGNAM_DISTANCE, GYODAE_GANGNAM_TIME));
        stationDistanceList.get(Init.GYODAE.getStaionNumber()).add(new Section(Init.SOUTH_TERMINAL.getStaionNumber(),
                GYODAE_SOUTH_TERMINAL_DISTANCE, GYODAE_SOUTH_TERMINAL_TIME));
        stationDistanceList.get(Init.GANGNAM.getStaionNumber())
                .add(new Section(Init.YEOKSAM.getStaionNumber(), GANGNAM_YEOKSAM_DISTANCE, GANGNAM_YEOKSAM_TIME));
        stationDistanceList.get(Init.GANGNAM.getStaionNumber())
                .add(new Section(Init.YANGJAE.getStaionNumber(), GANGNAM_YANGJAE_DISTANCE, GANGNAM_YANGJAE_TIME));
        stationDistanceList.get(Init.SOUTH_TERMINAL.getStaionNumber()).add(new Section(Init.YANGJAE.getStaionNumber(),
                SOUTH_TERMINAL_YANGJAE_DISTANCE, SOUTH_TERMINAL_YANGJAE_TIME));
        stationDistanceList.get(Init.YANGJAE.getStaionNumber())
                .add(new Section(Init.MAEBONG.getStaionNumber(), YANGJAE_MAEBONG_DISTANCE, YANGJAE_MAEBONG_TIME));
        stationDistanceList.get(Init.YANGJAE.getStaionNumber()).add(new Section(Init.YANGJAE_FOREST.getStaionNumber(),
                YANGJAE_YANGJAE_FOREST_DISTANCE, YANGJAE_YANGJAE_FOREST_TIME));
    }

    private void addInitDefaultStationSectionReverse(List<List<Section>> stationDistanceList) {
        stationDistanceList.get(Init.GANGNAM.getStaionNumber())
                .add(new Section(Init.GYODAE.getStaionNumber(), GYODAE_GANGNAM_DISTANCE, GYODAE_GANGNAM_TIME));

        stationDistanceList.get(Init.SOUTH_TERMINAL.getStaionNumber()).add(
                new Section(Init.GYODAE.getStaionNumber(), GYODAE_SOUTH_TERMINAL_DISTANCE, GYODAE_SOUTH_TERMINAL_TIME));

        stationDistanceList.get(Init.YEOKSAM.getStaionNumber())
                .add(new Section(Init.GANGNAM.getStaionNumber(), GANGNAM_YEOKSAM_DISTANCE, GANGNAM_YEOKSAM_TIME));
        stationDistanceList.get(Init.YANGJAE.getStaionNumber())
                .add(new Section(Init.GANGNAM.getStaionNumber(), GANGNAM_YANGJAE_DISTANCE, GANGNAM_YANGJAE_TIME));
        stationDistanceList.get(Init.YANGJAE.getStaionNumber()).add(new Section(Init.SOUTH_TERMINAL.getStaionNumber(),
                SOUTH_TERMINAL_YANGJAE_DISTANCE, SOUTH_TERMINAL_YANGJAE_TIME));

        stationDistanceList.get(Init.MAEBONG.getStaionNumber())
                .add(new Section(Init.YANGJAE.getStaionNumber(), YANGJAE_MAEBONG_DISTANCE, YANGJAE_MAEBONG_TIME));
        stationDistanceList.get(Init.YANGJAE_FOREST.getStaionNumber()).add(new Section(Init.YANGJAE.getStaionNumber(),
                YANGJAE_YANGJAE_FOREST_DISTANCE, YANGJAE_YANGJAE_FOREST_TIME));
    }
}
