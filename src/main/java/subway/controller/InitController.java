package subway.controller;

import subway.service.LineService;
import subway.service.StationService;

public class InitController {
    private final StationService stationService;
    private final LineService lineService;

    private InitController(StationService stationService, LineService lineService) {
        this.stationService = stationService;
        this.lineService = lineService;
    }

    public static InitController createInitController(StationService stationService, LineService lineService) {
        return new InitController(stationService, lineService);
    }

    public void init() {
        stationService.registerStation();
        lineService.registerLine();
    }
}
