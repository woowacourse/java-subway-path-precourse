package subway;

import org.junit.jupiter.api.Test;
import subway.domain.Station;
import subway.domain.StationRepository;

import static org.junit.jupiter.api.Assertions.*;

class SubwayTest {

    @Test
    void getShortestTime() {

        Subway subway = new Subway();

        Station v1 = StationRepository.findStationByName("교대역");
        Station v2 = StationRepository.findStationByName("양재역");

        double time = subway.getShortestTime(v1, v2);
        System.out.println(time);

    }
}