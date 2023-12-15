package subway.config;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;

public class AppConfig {

    public void setStation() {
        Station gyodae = new Station("교대역");
        Station gangnam = new Station("강남역");
        Station yeoksam = new Station("역삼역");
        Station nambuTerminal = new Station("남부터미널역");
        Station yangjae = new Station("양재역");
        Station yangjaeCitizenForest = new Station("양재시민의숲역");
        Station maebong = new Station("매봉역");

        List<Station> stations = List.of(gyodae, gangnam, yeoksam, nambuTerminal, yangjae, yangjaeCitizenForest, maebong);

        stations.stream().forEach(station -> StationRepository.addStation(station));
    }

    public void setLine() {
        Line two = new Line("2호선");
        Line three = new Line("3호선");
        Line sinbundang = new Line("신분당선");

        List<Line> lines = List.of(two, three, sinbundang);

        lines.stream().forEach(line -> LineRepository.addLine(line));
    }
}
