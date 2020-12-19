package subway.domain;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import subway.domain.section.Distance;

class DistanceTest {

    @Test
    @Description("Distance 생성 테스트")
    public void DistanceCreateTest(){

        Distance of = Distance.of(10);

        System.out.println(of.toString());
    }

    @Test
    @Description("Distance add 테스트, 더하기 기능")
    public void distanceAddTest(){

        long a = 10L;
        long b = 20L;

        Distance distanceA = Distance.of(a);
        Distance distanceB = Distance.of(b);

        Distance result = distanceA.add(distanceB);

        Assertions.assertTrue(result.equals(Distance.of(a+b)));

    }

    @Test
    @Description("Distance toString 확인, 접두사로 km")
    public void distanceToStringTest(){

        Distance result = Distance.of(10);

        System.out.println(result.toString());

    }

}