package subway.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ShortestPathFinderTest {

    @BeforeAll
    static void setUp() {
        List<String> stationNames =
                Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        List<String> lineNames = Arrays.asList("2호선", "3호선", "신분당선");

        for (String stationName : stationNames) {
            StationRepository.addStation(new Station(stationName));
        }

        Line second = new Line("2호선");
        LineRepository.addLine(second);
        SectionRepository.addSection(second,SectionFactory.makeSection(new Station("교대역"), new Station("강남역"), 2, 3));
        SectionRepository.addSection(second,SectionFactory.makeSection(new Station("강남역"), new Station("역삼역"), 2, 3));

        Line third = new Line("3호선");
        LineRepository.addLine(third);

        SectionRepository.addSection(third,SectionFactory.makeSection(new Station("교대역"), new Station("남부터미널역"), 3, 2));
        SectionRepository.addSection(third,SectionFactory.makeSection(new Station("남부터미널역"), new Station("양재역"), 6, 5));
        SectionRepository.addSection(third,SectionFactory.makeSection(new Station("양재역"), new Station("매봉역"), 1, 1));

        Line newBundang = new Line("신분당선");
        LineRepository.addLine(newBundang);
        SectionRepository.addSection(newBundang, SectionFactory.makeSection(new Station("강남역"), new Station("양재역"), 2, 8));
        SectionRepository.addSection(newBundang, SectionFactory.makeSection(new Station("양재역"), new Station("양재시민의숲역"), 10, 3));
    }

    @DisplayName("타입별로 되는지 확인")
    @Test
    void setType() {
    }

    @DisplayName("최단개수의 역 구하기")
    @Test
    void calculateShortest() {
        ShortestPathFinder shortestPathFinder = new ShortestPathFinder(StationRepository.stations(), SectionRepository.allSections());
        shortestPathFinder.setType(FindPathType.DISTANCE);
        int distance = shortestPathFinder.calculateShortestStationNumber(StationRepository.findByName("교대역"), StationRepository.findByName("양재시민의숲역"));
        assertThat(distance).isEqualTo(4);
    }

    @DisplayName("경로상의 모든 역 구하기")
    @Test
    void getStationsOnPath() {
        ShortestPathFinder shortestPathFinder = new ShortestPathFinder(StationRepository.stations(), SectionRepository.allSections());
        shortestPathFinder.setType(FindPathType.DISTANCE);

        List<Station> expectedList = Arrays.asList(new Station("교대역"), new Station("강남역"),new Station("양재역"),new Station("양재시민의숲역"));
        assertThat(shortestPathFinder.getStationsOnPath(StationRepository.findByName("교대역"), StationRepository.findByName("양재시민의숲역"))).isEqualTo(expectedList);
    }
}