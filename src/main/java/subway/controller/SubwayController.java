package subway.controller;

import subway.service.SubwayService;

public class SubwayController {
    private final SubwayService subwayService;

    public SubwayController(){
        subwayService = new SubwayService();
    }

    public void initSubway(){
        subwayService.initSubway();
    }
}
