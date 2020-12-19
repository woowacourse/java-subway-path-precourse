package subway.controller;

import subway.domain.Line.LineRepository;
import subway.domain.section.SectionWithDistanceRepository;
import subway.domain.section.SectionWithTimeRepository;
import subway.domain.station.StationRepository;
import subway.service.LineService;
import subway.service.SectionService;
import subway.service.StationService;
import subway.view.InputView;
import subway.view.MainChoice;
import subway.view.OutputView;
import subway.view.StandardChoice;

public class SubwayController {
    private LineService lineService;
    private StationService stationService;
    SectionService sectionService;
    InputView inputView;

    public SubwayController(LineService lineService, StationService stationService,
                            SectionService sectionService, InputView inputView) {
        this.lineService = lineService;
        this.stationService = stationService;
        this.sectionService = sectionService;
        this.inputView = inputView;
    }

    public void run() {
        try {
            mainChoice();
        } catch (Exception e) {
            OutputView.errorOutput(e.getMessage());
            run();
        }
    }

    public void mainChoice() {
        OutputView.selectMainFunction();
        OutputView.selectFunction();
        MainChoice choice = MainChoice.of(inputView.scan());
        mainFunction(choice);
    }

    public void mainFunction(MainChoice choice) {
        if(choice == MainChoice.FIND) {
            standardChoice();
        }

        if(choice == MainChoice.EXIT) {
            return;
        }
    }

    public void standardChoice() {
        OutputView.selectStandardFunction();
        OutputView.selectFunction();
        StandardChoice choice = StandardChoice.of(inputView.scan());
        standardFunction(choice);
    }

    public void standardFunction(StandardChoice choice) {
        if(choice == StandardChoice.DISTANCE) {
            distance();
        }

        if(choice == StandardChoice.TIME) {
            time();
        }

        if(choice == StandardChoice.BACK) {
            return;
        }
    }

    public void distance() {
        OutputView.inputStartStation();
        String start = inputView.scan();
        OutputView.inputEndStation();
        String end = inputView.scan();
        OutputView.findResult(sectionService.findShortestDistancePathByName(start, end));
    }

    public void time() {
        OutputView.inputStartStation();
        String start = inputView.scan();
        OutputView.inputEndStation();
        String end = inputView.scan();
        OutputView.findResult(sectionService.findShortestTimePathByName(start, end));
    }
}
