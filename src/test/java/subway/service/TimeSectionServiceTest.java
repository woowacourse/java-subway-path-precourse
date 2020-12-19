package subway.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import subway.domain.Distance;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.Time;

public class SectionServiceTest {

    @Test
    public void testSearchStations() {
        Station source = Station.newStationWithName("교대역");
        Station station1 = Station.newStationWithName("우리역");
        Station station2 = Station.newStationWithName("나라역");
        Station station3 = Station.newStationWithName("만세역");
        Station destination = Station.newStationWithName("강남역");

        Section section1 = Section
            .newSectionWithStations(source, station1, Distance.newDistance(1), Time.newTime(1));
        Section section2 = Section.newSectionWithStations(station2, station1, Distance.newDistance(1), Time.newTime(1));
        Section section3 = Section.newSectionWithStations(station3, station2, Distance.newDistance(1), Time.newTime(1));
        Section section4 = Section.newSectionWithStations(destination, source, Distance.newDistance(1), Time.newTime(1));

        SectionRepository.addSection(section1);
        SectionRepository.addSection(section2);
        SectionRepository.addSection(section3);
        SectionRepository.addSection(section4);

        assertThat(SectionRepository.searchLinked(source, destination)).isTrue();
    }

}
