package subway;

import subway.Initialization.LineInitialization;
import subway.Initialization.SectionInitialization;
import subway.Initialization.StationInitialization;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.router.MainRouter;
import subway.view.InputView;
import java.util.Arrays;
import java.util.Scanner;

public class SubwayMap {

    private SubwayMap() { }

    public void run(Scanner scanner) {
        init(scanner);
        MainRouter.run();
    }

    private void init(Scanner scanner) {
        initInputView(scanner);
        initStations();
        initLines();
    }

    private void initInputView(Scanner scanner) {
        InputView.init(scanner);
    }

    private void initStations() {
        Arrays.stream(StationInitialization.values())
                .forEach(station -> StationRepository.addStation(new Station(station.getName())));
    }

    private void initLines() {
        Arrays.stream(LineInitialization.values())
                .forEach(line ->
                        LineRepository.addLine(
                                new Line(line.getName(),
                                        SectionInitialization.getSectionInitialization(line).sections()))
                );
    }

    public static SubwayMap getInstance() {
        return SubwayMap.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final SubwayMap INSTANCE = new SubwayMap();
    }
}