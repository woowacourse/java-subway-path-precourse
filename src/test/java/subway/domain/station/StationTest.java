package subway.domain.station;

import org.junit.jupiter.api.Test;

class StationTest {

    @Test
    public void destinationTest(){

        Station instance = Destination.getInstance();
        System.out.println(instance);

    }

}