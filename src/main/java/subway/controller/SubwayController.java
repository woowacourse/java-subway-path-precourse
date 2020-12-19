package subway.controller;

import subway.InitialData;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SubwayController {

    public void run() {
        InitialData init = new InitialData();
        init.initialDataInput();
        MainController.run();
    }
}
