package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class InitialData {

    public void initialDataInput() {
        stationAdd();
        lineAdd();
        sectionAdd();
    }

    private void sectionAdd() {
        SectionRepository.addSection(
            new Section(StationRepository.getStationByName("교대역")
                , StationRepository.getStationByName("강남역")
                , 2
                , 3));
        SectionRepository.addSection(
            new Section(StationRepository.getStationByName("강남역")
                , StationRepository.getStationByName("역삼역")
                , 2
                , 3));
        SectionRepository.addSection(
            new Section(StationRepository.getStationByName("강남역")
                , StationRepository.getStationByName("역삼역")
                , 2
                , 3));

        SectionRepository.addSection(
            new Section(StationRepository.getStationByName("교대역")
                , StationRepository.getStationByName("남부산터미널역")
                , 3
                , 2));
        SectionRepository.addSection(
            new Section(StationRepository.getStationByName("남부산터미널역")
                , StationRepository.getStationByName("양재역")
                , 6
                , 5));
        SectionRepository.addSection(
            new Section(StationRepository.getStationByName("양재역")
                , StationRepository.getStationByName("매봉역")
                , 1
                , 1));

        SectionRepository.addSection(
            new Section(StationRepository.getStationByName("강남역")
                , StationRepository.getStationByName("양재역")
                , 2
                , 8));
        SectionRepository.addSection(
            new Section(StationRepository.getStationByName("양재역")
                , StationRepository.getStationByName("양재시민의숲역")
                , 10
                , 3));
    }

    private void lineAdd() {
        LineRepository.addLine(new Line("2호선"));
        LineRepository.addLine(new Line("3호선"));
        LineRepository.addLine(new Line("신분당선"));
    }

    private void stationAdd() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부산터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));
    }


}
