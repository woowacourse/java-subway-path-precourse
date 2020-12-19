package subway.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import subway.DummyData;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SearchControllerTest {

    SearchController searchController = new SearchController(new Scanner(System.in));

    @Test
    @DisplayName("존재하지 않는 역에 대한 에러 발생 기대")
    void getStation() {
        DummyData.initialize();
        assertThrows(IllegalArgumentException.class, () -> {
            StationRepository.getStation("없는역");
        });
    }

    @Test
    @DisplayName("출발역과 도착역 동일 에러 발생 기대")
    void search() {
        DummyData.initialize();
        assertThrows(IllegalArgumentException.class, () -> {
            Station station = StationRepository.getStation("교대역");
            searchController.getShortestByDistance(station, station);
        });
    }

    @Test
    @DisplayName("교대역과 양재역의 거리 기준 최소 경로는 강남역을 지나는 것을 기대")
    void searchByDistance() {
        DummyData.initialize();
        Station from = StationRepository.getStation("교대역");
        Station to = StationRepository.getStation("양재역");
        List<Station> shortestByDistance = searchController.getShortestByDistance(from, to);

        Station middle = StationRepository.getStation("강남역");
        assertEquals(shortestByDistance.get(1), middle);
    }

    @Test
    @DisplayName("교대역과 양재역의 시간 기준 최소 경로는 교대역을 지나는 것을 기대")
    void searchByTime() {
        DummyData.initialize();
        Station from = StationRepository.getStation("남부터미널역");
        Station to = StationRepository.getStation("강남역");
        List<Station> shortestByTime = searchController.getShortestByTime(from, to);

        Station middle = StationRepository.getStation("교대역");
        assertEquals(shortestByTime.get(1), middle);
    }

    @Test
    @DisplayName("도달할 수 없는 역에 대한 예외 발생 기대")
    void searchToNonLinkedStation() {
        DummyData.initialize();
        StationRepository.addStation(new Station("도달하지못하는역"));

        Station from = StationRepository.getStation("남부터미널역");
        Station to = StationRepository.getStation("도달하지못하는역");

        assertThrows(IllegalArgumentException.class, () -> {
            List<Station> shortestByTime = searchController.getShortestByTime(from, to);
        });
    }
}