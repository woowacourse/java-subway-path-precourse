package subway.domain;

import static org.junit.jupiter.api.Assertions.*;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TimeTest {

    @Test
    @Description("Time 생성 테스트")
    public void TimeCreateTest(){

        long minute = 60L;

        Time time = Time.of(minute);
        System.out.println(time.getMinute());
        Assertions.assertTrue(time.getMinute() == minute);

    }

    @Test
    @Description("Time 더하기 테스ㅌ")
    public void timeAddTest(){

        long secondsA = 60L;
        long secondsB = 40L;

        Time timeA = Time.of(secondsA);
        Time timeB = Time.of(secondsB);

        Time result = timeA.add(timeB);

        Assertions.assertTrue(result.equals(secondsA+secondsB));

    }

    @Test
    @Description("toString 확인")
    public void TimeToStringTest(){

        Time of = Time.of(10);

        System.out.println(of.toString());

    }

}