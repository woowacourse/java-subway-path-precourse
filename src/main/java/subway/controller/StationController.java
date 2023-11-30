package subway.controller;

import subway.service.StationService;

public class StationController {
    private final StationService stationService;

    public StationController(){
        stationService = new StationService();
    }

    public void initStation(){
        stationService.initStation();
    }
}
