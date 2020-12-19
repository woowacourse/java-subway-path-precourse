package subway.service;

import subway.domain.section.*;
import subway.exception.SameStationException;

public class SectionService {
    SectionWithDistanceRepository sectionWithDistanceRepository;
    SectionWithTimeRepository sectionWithTimeRepository;

    public SectionService(SectionWithDistanceRepository sectionWithDistanceRepository,
                          SectionWithTimeRepository sectionWithTimeRepositor) {
        this.sectionWithDistanceRepository = sectionWithDistanceRepository;
        this.sectionWithTimeRepository = sectionWithTimeRepositor;
    }

    public SectionsAndTime findShortestTimePathByName(String from, String to) {
        validateSameStation(from, to);
        return sectionWithTimeRepository.find(from, to);
    }

    public SectionsAndDistance findShortestDistancePathByName(String from, String to) {
        validateSameStation(from, to);
        return sectionWithDistanceRepository.find(from, to);
    }

    public void validateSameStation(String from, String to) {
        if(from.equals(to)) {
            throw new SameStationException();
        }
    }
}
