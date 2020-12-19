package subway.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import subway.InitDataList;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubwayAgencyTest {

    public SubwayAgencyTest() {
        InitDataList.insertData();
    }

    @Test
    public void testByDistance() throws Exception{
        //given
        int expectedDistance = 4;
        int expectedTime = 11;
        List<Line> lines = LineRepository.lines();
        SubwayAgency subwayAgency = new SubwayAgency(new SubwayMap(lines));
        //when
        GraphResult resultByDistance = subwayAgency.getResultByDistance(new StationBetween("교대역", "양재역"));
        //then
        Assertions.assertEquals(expectedDistance, resultByDistance.getDistance());
        Assertions.assertEquals(expectedTime, resultByDistance.getTime());
    }

    @Test
    public void testByTime() throws Exception{
        //given
        int expectedDistance = 9;
        int expectedTime = 7;
        List<Line> lines = LineRepository.lines();
        SubwayAgency subwayAgency = new SubwayAgency(new SubwayMap(lines));
        //when
        GraphResult resultByTime = subwayAgency.getResultByTime(new StationBetween("교대역", "양재역"));
        //then
        Assertions.assertEquals(expectedDistance, resultByTime.getDistance());
        Assertions.assertEquals(expectedTime, resultByTime.getTime());
    }

}