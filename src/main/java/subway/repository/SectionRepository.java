package subway.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.domain.Section.Distance;
import subway.domain.Section.Section;
import subway.domain.Section.Time;
import subway.domain.line.Line;
import subway.domain.station.Station;
import subway.exception.AlreadyExistSectionException;

public class SectionRepository {

    List<Section> sections = new ArrayList<>();

    static {    //샘플 데이터

        SectionRepository repository = new SectionRepository();
        LineRepository lineRepository = new LineRepository();
        StationRepository stationRepository = new StationRepository();
        Line line1 = Line.of("2호선");
        Line line2 = Line.of("3호선");
        Line line3 = Line.of("신분당선");

        lineRepository.addLine(line1);
        lineRepository.addLine(line2);
        lineRepository.addLine(line3);

        Station station1 = Station.of("교대역");
        Station station2 = Station.of("강남역");
        Station station3 = Station.of("역삼역");
        Station station4 = Station.of("남부터미널역");
        Station station5 = Station.of("양재역 ");
        Station station6 = Station.of("매봉역 ");
        Station station7 = Station.of("양재시민의숲역 ");

        stationRepository.addStation(station1);
        stationRepository.addStation(station2);
        stationRepository.addStation(station3);
        stationRepository.addStation(station4);
        stationRepository.addStation(station5);
        stationRepository.addStation(station6);
        stationRepository.addStation(station7);

        Section section1 = Section.create(line1, station1, station2, Time.of(3), Distance.of(2));
        Section section2 = Section.create(line1, station2, station3, Time.of(3), Distance.of(2));

        Section section3 = Section.create(line2, station1, station4, Time.of(2), Distance.of(3));
        Section section4 = Section.create(line2, station4, station5, Time.of(5), Distance.of(6));
        Section section5 = Section.create(line2, station5, station6, Time.of(1), Distance.of(1));

        Section section6 = Section.create(line3, station2, station5, Time.of(8), Distance.of(2));
        Section section7 = Section.create(line3, station5, station7, Time.of(3), Distance.of(10));

        repository.addSection(section1);
        repository.addSection(section2);
        repository.addSection(section3);
        repository.addSection(section4);
        repository.addSection(section5);
        repository.addSection(section6);
        repository.addSection(section7);

        line1.addSection(section1);
        line1.addSection(section2);
        line1.addSection(section3);
        line1.addSection(section4);
        line1.addSection(section5);
        line1.addSection(section6);
        line1.addSection(section7);

    }

    public List<Section> findAll() {
        return Collections.unmodifiableList(sections);
    }


    public Section findByStations(Station preStation, Station nextStation) {
        return sections.stream()
            .filter(section -> section.isMatchStations(preStation, nextStation))
            .findFirst()
            .orElseThrow(() -> {
                throw new IllegalArgumentException("[ERROR] 해당 구간을 찾을 수 없습니다.");
            });
    }

    public void addSection(Section section) {

        if (sections.contains(section)) {
            throw new AlreadyExistSectionException(section);
        }

        sections.add(section);
    }

}
