package subway.model;

import subway.model.domain.*;

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

        DistanceRepository distance = new DistanceRepository();
        distance.addStation(snue);
        distance.addStation(gangnam);
        distance.addStation(yeoksam);
        distance.addStation(nambuTerminal);
        distance.addStation(yangjae);
        distance.addStation(yangjaeForest);
        distance.addStation(maebong);
        distance.addDistance(snue, gangnam, 2);
        distance.addDistance(gangnam, yeoksam, 2);
        distance.addDistance(snue, nambuTerminal, 3);
        distance.addDistance(nambuTerminal, yangjae, 6);
        distance.addDistance(yangjae, maebong, 1);
        distance.addDistance(gangnam, yangjae, 2);
        distance.addDistance(yangjae, yangjaeForest, 10);

        TimeRepository time = new TimeRepository();
        time.addStation(snue);
        time.addStation(gangnam);
        time.addStation(yeoksam);
        time.addStation(nambuTerminal);
        time.addStation(yangjae);
        time.addStation(yangjaeForest);
        time.addStation(maebong);
        time.addTime(snue, gangnam, 3);
        time.addTime(gangnam, yeoksam, 3);
        time.addTime(snue, nambuTerminal, 2);
        time.addTime(nambuTerminal, yangjae, 5);
        time.addTime(yangjae, maebong, 1);
        time.addTime(gangnam, yangjae, 8);
        time.addTime(yangjae, yangjaeForest, 3);
    }
}
