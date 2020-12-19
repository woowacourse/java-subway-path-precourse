package subway.model;

import subway.model.domain.Line;
import subway.model.domain.LineRepository;
import subway.model.domain.Station;
import subway.model.domain.StationRepository;

public class SubwayInit {
    public SubwayInit() {
        Station snue = new Station("교대역");
        Station gangnam = new Station("강남역");
        Station yeoksam = new Station("역삼역");
        Station nambuTerminal = new Station("남부터미널역");
        Station yangjae = new Station("양재역");
        Station yangjaeForest = new Station("양재시민의숲역");
        Station maebong = new Station("매봉역");
        StationRepository.addStation(snue);
        StationRepository.addStation(gangnam);
        StationRepository.addStation(yeoksam);
        StationRepository.addStation(nambuTerminal);
        StationRepository.addStation(yangjae);
        StationRepository.addStation(yangjaeForest);
        StationRepository.addStation(maebong);

        Line second = new Line("2호선");
        Line third = new Line("3호선");
        Line sinbundang = new Line("신분당선");
        LineRepository.addLine(second);
        LineRepository.addLine(third);
        LineRepository.addLine(sinbundang);
    }
}
