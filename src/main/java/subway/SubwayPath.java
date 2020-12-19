package subway;

import subway.domain.DistanceSectionRepository;
import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.StationRepository;
import subway.domain.TimeSectionRepository;
import subway.view.MainDisplay;

public class SubwayPath {

    private SubwayPath() {
        StationRepository.initStationRepository();
        LineRepository.initLineRepository();
        SectionRepository.initSectionRepository();
        DistanceSectionRepository.initDistanceSectionRepository();
        TimeSectionRepository.initTimeSectionRepository();
    }

    public static SubwayPath newSubwayPath() {
        return new SubwayPath();
    }

    public void start() {
        MainDisplay.loadMenu();
    }
}
