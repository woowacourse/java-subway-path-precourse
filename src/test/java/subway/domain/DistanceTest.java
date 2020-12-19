package subway.domain;

import static org.junit.jupiter.api.Assertions.*;

import jdk.jfr.Description;
import jdk.swing.interop.SwingInterOpUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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


}