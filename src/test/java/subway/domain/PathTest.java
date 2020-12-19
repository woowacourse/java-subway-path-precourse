package subway.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathTest {

    @Test
    public void createPathSuccess() throws Exception{
        //given
        Station start = new Station("의정부역");
        Station end = new Station("서울역");
        int time = 3;
        int distance = 4;
        //when

        Path path = new Path(start, end, time, distance);
        //then
        Assertions.assertEquals(start, path.getStartStation());
        Assertions.assertEquals(end, path.getEndStation());
    }

}