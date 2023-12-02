package subway.controller;

import subway.service.LineService;

public class LineController {

    private final LineService lineService;
    public LineController(){
        lineService = new LineService();
    }

    public void initLine(){
        lineService.initLine();
    }
}
