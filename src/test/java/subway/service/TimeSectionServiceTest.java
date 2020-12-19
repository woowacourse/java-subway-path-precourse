package subway.service;

import org.junit.jupiter.api.Test;
import subway.domain.Station;

public class TimeSectionServiceTest {

    @Test
    public void testSearchStations() {
        Station source = Station.newStationWithName("교대역");
        Station station1 = Station.newStationWithName("우리역");
        Station station2 = Station.newStationWithName("나라역");
        Station station3 = Station.newStationWithName("만세역");
        Station destination = Station.newStationWithName("강남역");
//
//        Section section1 = Section
//            .newSectionWithStations(source, station1, Distance.newDistance(1), Time.newTime(1));
//        Section section2 = Section.newSectionWithStations(station2, station1, Distance.newDistance(1), Time.newTime(1));
//        Section section3 = Section.newSectionWithStations(station3, station2, Distance.newDistance(1), Time.newTime(1));
//        Section section4 = Section.newSectionWithStations(destination, source, Distance.newDistance(1), Time.newTime(1));
//
//        TimeSectionRepository.addSection(section1);
//        TimeSectionRepository.addSection(section2);
//        TimeSectionRepository.addSection(section3);
//        TimeSectionRepository.addSection(section4);
//
//        assertThat(TimeSectionRepository.searchLinked(source, destination)).isTrue();
    }

}
