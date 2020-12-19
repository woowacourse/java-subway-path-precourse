package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SectionTest {

    @Test

    public void testSectionCreate() {
        Station source = Station.newStationWithName("교대역");
        Station destination = Station.newStationWithName("강남역");
        Time time = Time.newTime(5);
        Distance distance = Distance.newDistance(10);
        Section section = Section.newSectionWithStations(source, destination, distance, time);
        assertThat(section.getTime().getMinute()).isEqualTo(5);
    }

}
