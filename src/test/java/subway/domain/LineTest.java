package subway.domain;

import org.junit.jupiter.api.Test;
import subway.InitDataList;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    public LineTest() {
        InitDataList.insertData();
    }

    @Test
    public void createLineTest() throws Exception{
        //given
        List<Line> lines = LineRepository.lines();
        //when

        System.out.println(lines);
        //then
    }

}