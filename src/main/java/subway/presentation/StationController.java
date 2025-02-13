package subway.presentation;

import subway.application.section.service.SectionService;import subway.domain.station.StationDTO;
import subway.domain.station.StationService;

public class StationController {
    private final StationService stationService = new StationService();
    private final SectionService sectionService = new SectionService();

    public void addStation(String name) {
        StationDTO stationDTO = new StationDTO(name);
        this.stationService.addStation(stationDTO);
        this.sectionService.addNode(stationDTO);
    }
}
