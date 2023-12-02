package subway.repository;

import subway.domain.Line;
import subway.domain.Station;
import subway.util.constants.LineName;
import subway.util.constants.StationName;

import static subway.util.constants.DistanceInfo.*;
import static subway.util.constants.StationName.*;
import static subway.util.constants.TimeInfo.*;

public class SubwayRepository {

    static String[] twoLineStations = {GYODAE.getValue(), GANGNAM.getValue(), YEOKSAM.getValue()};
    static String[] threeLineStations = {GYODAE.getValue(), SOUTH_TERMINAL.getValue(),
            StationName.YANGJAE.getValue(), StationName.MAEBONG.getValue()};
    static String[] shinBundangLineStations = {GANGNAM.getValue(), StationName.YANGJAE.getValue(),
            StationName.YANGJAE_CITIZEN_FOREST.getValue()};
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
            Line line = lineRepository.findByName(lineName.getValue());
            addStationsInLine(line);
        }
    }

    private void initConnectInfo(){
        stationRepository.initConnectInfo(GYODAE.getValue(), GANGNAM.getValue(), GYODAE_GANGNAM_DISTANCE.getValue(), GYODAE_GANGNAM_TIME.getValue());
        stationRepository.initConnectInfo(GANGNAM.getValue(), YEOKSAM.getValue(), GANGNAM_YEOKSAM_DISTANCE.getValue(), GANGNAM_YEOKSAM_TIME.getValue());
        stationRepository.initConnectInfo(GYODAE.getValue(), SOUTH_TERMINAL.getValue(), GYODAE_SOUTH_TERMINAL_DISTANCE.getValue(), GYODAE_SOUTH_TERMINAL_TIME.getValue());
        stationRepository.initConnectInfo(SOUTH_TERMINAL.getValue(), YANGJAE.getValue(), SOUTH_TERMINAL_YANGJAE_DISTANCE.getValue(), SOUTH_TERMINAL_YANGJAE_TIME.getValue());
        stationRepository.initConnectInfo(YANGJAE.getValue(), MAEBONG.getValue(), YANGJAE_MAEBONG_DISTANCE.getValue(), YANGJAE_MAEBONG_TIME.getValue());
        stationRepository.initConnectInfo(GANGNAM.getValue(), YANGJAE.getValue(), GANGNAM_YANGJAE_DISTANCE.getValue(), GANGNAM_YANGJAE_TIME.getValue());
        stationRepository.initConnectInfo(YANGJAE.getValue(), YANGJAE_CITIZEN_FOREST.getValue(), YANGJAE_YANGJAE_CITIZEN_FORESET_DISTANCE.getValue(), YANGJAE_YANGJAE_CITIZEN_FORESET_TIME.getValue());
    }

    private void addStationsInLine(final Line line){
        if(line.isEqualName(LineName.LINE_2.getValue())){
            initStationsInLine(line, twoLineStations);
        }

        if(line.isEqualName(LineName.LINE_3.getValue())){
            initStationsInLine(line, threeLineStations);
        }

        if(line.isEqualName(LineName.SHIN_BUNDANG.getValue())){
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
