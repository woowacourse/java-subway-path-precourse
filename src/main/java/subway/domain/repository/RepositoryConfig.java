package subway.domain.repository;

import java.util.Set;
import subway.domain.Line;
import subway.domain.Station;
import subway.domain.UnitPath;

public class RepositoryConfig {

    public static void initRepository(){
        initStationRepository();
        initLineRepository();
    }

    private static void initStationRepository(){
        //todo enum 추출 가능할 듯 - 근데 class로 이미 있어서 의미 있나
        addStationToRepository(new Station("교대역"));
        addStationToRepository(new Station("강남역"));
        addStationToRepository(new Station("역삼역"));
        addStationToRepository(new Station("남부터미널역"));
        addStationToRepository(new Station("양재역"));
        addStationToRepository(new Station("매봉역"));
        addStationToRepository(new Station("양재시민의숲"));
    }

    public static void addStationToRepository(Station station){
        if(StationRepository.contains(station)){
            return;
        }
        StationRepository.addStation(station);
    }

    private static void initLineRepository() {
        Line line2 = new Line("2호선");
        line2.addPath(makePath("교대역", "강남역", 2, 3));
        line2.addPath(makePath("강남역", "역삼역", 2, 3));
        LineRepository.addLine(line2);

        Line line3 = new Line("3호선");
        line3.addPath(makePath("교대역", "남부터미널역", 3, 2));
        line3.addPath(makePath("남부터미널역", "양재역", 6, 5));
        line3.addPath(makePath("양재역", "매봉역", 1, 1));
        LineRepository.addLine(line3);

        Line shinbundang = new Line("신분당선");
        shinbundang.addPath(makePath("강남역", "양재역", 2, 8));
        shinbundang.addPath(makePath("양재역", "양재시민의숲", 10, 3));
        LineRepository.addLine(shinbundang);
    }

    public static UnitPath makePath(String startName, String endName, int distance, int time) {
        Station start = StationRepository.getStationByName(startName);
        Station end = StationRepository.getStationByName(endName);
        return new UnitPath(start, end, time, distance);
    }

    private static void initPathRepository(){
        LineRepository.lines().stream()
                .map(Line::getPaths)
                .flatMap(Set::stream)
                .forEach(PathRepository::addPath);

    }
}
