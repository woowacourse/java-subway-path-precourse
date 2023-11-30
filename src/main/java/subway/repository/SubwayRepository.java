package subway.repository;

import subway.domain.Line;
import subway.domain.Station;
import subway.util.constants.LineName;
import subway.util.constants.StationName;

import static subway.util.constants.DistanceInfo.*;
import static subway.util.constants.StationName.*;
import static subway.util.constants.TimeInfo.*;

public class SubwayRepository {

    static String[] twoLineStations = {GYODAE.getKey(), GANGNAM.getKey(), YEOKSAM.getKey()};
    static String[] threeLineStations = {GYODAE.getKey(), SOUTH_TERMINAL.getKey(),
            StationName.YANGJAE.getKey(), StationName.MAEBONG.getKey()};
    static String[] shinBundangLineStations = {GANGNAM.getKey(), StationName.YANGJAE.getKey(),
            StationName.YANGJAE_CITIZEN_FOREST.getKey()};
    private static final SubwayRepository subwayRepository = new SubwayRepository();
    private static final LineRepository lineRepository = LineRepository.getInstance();
    private static final StationRepository stationRepository = StationRepository.getInstance();

    private SubwayRepository(){

    }

    public static SubwayRepository getInstance(){
        return subwayRepository;
    }

    public void initSubway(){
        initStationsSpecificLine();
        initConnectInfo();
    }

    private void initStationsSpecificLine(){
        for(LineName lineName : LineName.values()){
            Line line = lineRepository.findByName(lineName.getKey());
            addStationsInLine(line);
        }
    }

    private void initConnectInfo(){
        stationRepository.initConnectInfo(GYODAE.getKey(), GANGNAM.getKey(), GYODAE_GANGNAM_DISTANCE.getValue(), GYODAE_GANGNAM_TIME.getValue());
        stationRepository.initConnectInfo(GANGNAM.getKey(), YEOKSAM.getKey(), GANGNAM_YEOKSAM_DISTANCE.getValue(), GANGNAM_YEOKSAM_TIME.getValue());
        stationRepository.initConnectInfo(GYODAE.getKey(), SOUTH_TERMINAL.getKey(), GYODAE_SOUTH_TERMINAL_DISTANCE.getValue(), GYODAE_SOUTH_TERMINAL_TIME.getValue());
        stationRepository.initConnectInfo(SOUTH_TERMINAL.getKey(), YANGJAE.getKey(), SOUTH_TERMINAL_YANGJAE_DISTANCE.getValue(), SOUTH_TERMINAL_YANGJAE_TIME.getValue());
        stationRepository.initConnectInfo(YANGJAE.getKey(), MAEBONG.getKey(), YANGJAE_MAEBONG_DISTANCE.getValue(), YANGJAE_MAEBONG_TIME.getValue());
        stationRepository.initConnectInfo(GANGNAM.getKey(), YANGJAE.getKey(), GANGNAM_YANGJAE_DISTANCE.getValue(), GANGNAM_YANGJAE_TIME.getValue());
        stationRepository.initConnectInfo(YANGJAE.getKey(), YANGJAE_CITIZEN_FOREST.getKey(), YANGJAE_YANGJAE_CITIZEN_FORESET_DISTANCE.getValue(), YANGJAE_YANGJAE_CITIZEN_FORESET_TIME.getValue());
    }

    private void addStationsInLine(final Line line){
        if(line.isEqualName(LineName.LINE_2.getKey())){
            initStationsInLine(line, twoLineStations);
        }

        if(line.isEqualName(LineName.LINE_3.getKey())){
            initStationsInLine(line, threeLineStations);
        }

        if(line.isEqualName(LineName.SHIN_BUNDANG.getKey())){
            initStationsInLine(line, shinBundangLineStations);
        }
    }

    public static void initStationsInLine(final Line line, final String[] stations){
        for(String stationInfo : stations){
            Station station = stationRepository.findByName(stationInfo);
            line.addStationsInLine(station);
        }
    }
}
