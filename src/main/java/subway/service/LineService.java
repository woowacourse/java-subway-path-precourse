package subway.service;

import subway.domain.Line.Line;
import subway.domain.Line.LineRepository;
import subway.domain.section.DistanceAndTime;
import subway.domain.section.SectionWithDistanceRepository;
import subway.domain.section.SectionWithTimeRepository;
import subway.domain.station.Station;

import java.util.List;
import java.util.stream.IntStream;

public class LineService {
    LineRepository lineRepository;
    SectionWithDistanceRepository sectionWithDistanceRepository;
    SectionWithTimeRepository sectionWithTimeRepository;

    public LineService(LineRepository lineRepository,
                       SectionWithDistanceRepository sectionWithDistanceRepository,
                       SectionWithTimeRepository sectionWithTimeRepository) {
        this.lineRepository = lineRepository;
        this.sectionWithDistanceRepository = sectionWithDistanceRepository;
        this.sectionWithTimeRepository = sectionWithTimeRepository;
    }

    public void add(String name, List<Station> sections, List<DistanceAndTime> distanceAndTimes) {
        Line line = new Line(name, sections, distanceAndTimes);
        lineRepository.save(line);
        addToSectionRepository(sections, distanceAndTimes);
    }

    private void addToSectionRepository(List<Station> sections, List<DistanceAndTime> distanceAndTimes) {
        IntStream.range(0, sections.size()-1).forEach(index -> {
            sectionWithDistanceRepository.save(sections.get(index).getName(),
                    sections.get(index+1).getName(), distanceAndTimes.get(index));
            sectionWithTimeRepository.save(sections.get(index).getName(),
                    sections.get(index+1).getName(), distanceAndTimes.get(index));
        });
    }
}
