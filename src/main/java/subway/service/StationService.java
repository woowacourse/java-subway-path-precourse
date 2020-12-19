package subway.service;

import java.util.Arrays;
import java.util.List;
import subway.domain.Station;
import subway.domain.StationRepository;

/*
 * 지하철 역에 관련된 기능을 관리하는 클래스
 *
 * @author 483759@naver.com / 윤이진
 * @version 1.0 2020/12/19
* */
public class StationService {
    public static final List<String> stationNameList = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "매봉역", "양재시민의숲역");

    public StationService(){
        initialize();
    }

    public static void initialize(){
        for(String stationName: stationNameList){
            if(StationRepository.contains(stationName))
                continue;
            if(!validateName(stationName))
                continue;
            Station station = new Station(stationName);
            StationRepository.addStation(station);
        }
    }

    public static boolean validateName(String name){
        Character lastCharacter = name.charAt(name.length()-1);
        if(lastCharacter.equals('역'))
            return true;
        return false;
    }
}
