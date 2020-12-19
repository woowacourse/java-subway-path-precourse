package subway.manager;

import subway.domain.section.service.SectionService;
import subway.domain.station.model.Station;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PathManager implements Manager {
    private static final String NOT_VALID_INPUT_VALUE_MESSAGE = "[ERROR] 선택할 수 없는 기능입니다.\n";

    @Override
    public void execute(Scanner scanner) {
        OutputView.printPathMenu();
        String input = InputView.inputValue(scanner);
        try {
            SectionMenu sectionMenu = SectionMenu.of(input);
            executeSectionManagement(scanner, sectionMenu);
            executeNextPage(scanner, input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            execute(scanner);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            execute(scanner);
        }
    }

    private void executeSectionManagement(Scanner scanner, SectionMenu sectionMenu) {
        if (sectionMenu.equals(SectionMenu.MINIMUM_DISTANCE)) {
            Station startStation = InputView.inputStartStation(scanner);
            Station arrivalStation = InputView.inputArrivalStation(scanner);
            executeFindDistanceShortestPath(startStation, arrivalStation);
            return;
        }

        if (sectionMenu.equals(SectionMenu.MINIMUM_RUNTIME)) {
            Station startStation = InputView.inputStartStation(scanner);
            Station arrivalStation = InputView.inputArrivalStation(scanner);
            executeFindRunTimeShortestPath(startStation, arrivalStation);
        }
    }

    private void executeFindRunTimeShortestPath(Station startStation, Station arrivalStation) {
        List<Station> path = SectionService.findRunTimeShortestPath(startStation, arrivalStation);
        int totalDistance = SectionService.findTotalDistance(path);
        int totalRunTime = SectionService.findTotalRunTime(path);
        OutputView.printResult(totalDistance, totalRunTime, path);
    }

    private void executeFindDistanceShortestPath(Station startStation, Station arrivalStation) {
        List<Station> path = SectionService.findDistanceShortestPath(startStation, arrivalStation);
        int totalDistance = SectionService.findTotalDistance(path);
        int totalRunTime = SectionService.findTotalRunTime(path);
        OutputView.printResult(totalDistance, totalRunTime, path);
    }

    private void executeNextPage(Scanner scanner, String input) {
        Arrays.stream(SectionMenu.values())
                .filter(value -> value.isEqualTo(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_VALID_INPUT_VALUE_MESSAGE))
                .manager.execute(scanner);
    }

    public enum SectionMenu {
        MINIMUM_DISTANCE("1", new MainManager()),
        MINIMUM_RUNTIME("2", new MainManager()),
        RETURN_MAIN_PAGE("B", new MainManager());

        private final String input;
        private final Manager manager;

        SectionMenu(String input, Manager manager) {
            this.input = input;
            this.manager = manager;
        }

        public static SectionMenu of(String input) {
            return Arrays.stream(values())
                    .filter(value -> value.isEqualTo(input))
                    .findAny()
                    .orElseThrow(() -> new IllegalArgumentException(NOT_VALID_INPUT_VALUE_MESSAGE));
        }

        public boolean isEqualTo(String input) {
            return this.input.equalsIgnoreCase(input);
        }
    }
}
