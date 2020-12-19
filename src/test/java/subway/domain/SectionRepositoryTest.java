package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SectionRepositoryTest {

    @Test

    public void testSectionCreate() {
        Station source = Station.newStationWithName("교대역");
        Station station1 = Station.newStationWithName("강남역");
        Station destination = Station.newStationWithName("상봉역");
//        DistanceSectionRepository.addSection(source, station1, Distance.newDistance(5));
//        DistanceSectionRepository.addSection(destination, station1, Distance.newDistance(10));
//        assertThat(DistanceSectionRepository.getShortestPath(source, destination).size()).isEqualTo(3);
//        System.out.println(DistanceSectionRepository.getShortestPath(source, destination));
    }

}
