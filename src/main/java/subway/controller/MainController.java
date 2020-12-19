package subway.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;
import utils.LineUtils;

public class MainController {
    private static final List<String> EXIT_SIGN = Arrays.asList("q", "Q");
    private static final int START = 1;
    private static final int MENU_END = 1;

    private MainController() {
    }

    public static void runSubwayPath(Scanner scanner) {
        init();
        System.out.println(LineRepository.lines().get(0).getTerminals().get(0).getName());
        String selection;
        do {
            OutputView.printMenu(LineUtils.MAIN_MENU);
            selection = InputView.inputSelection(scanner);
            executeSelection(scanner, selection);
        } while (!EXIT_SIGN.contains(selection));
    }

    private static void init() {
        LineRepository.addLine(new Line("2호선",
            Arrays.asList(StationRepository.findStation("교대역"), StationRepository.findStation("강남역"), StationRepository.findStation("역삼역")),
            Arrays.asList(2, 2),
            Arrays.asList(3, 3)));
        LineRepository.addLine(new Line("3호선",
            Arrays.asList(StationRepository.findStation("교대역"), StationRepository.findStation("남부터미널역"), StationRepository.findStation("양재역"), StationRepository.findStation("매봉역")),
            Arrays.asList(3, 6, 1),
            Arrays.asList(2, 5, 1)));
        LineRepository.addLine(new Line("신분당선",
            Arrays.asList(StationRepository.findStation("강남역"), StationRepository.findStation("양재역"), StationRepository.findStation("양재시민의숲역")),
            Arrays.asList(2, 10),
            Arrays.asList(8, 3)));
    }

    // TODO 검증 나누기
    private static void executeSelection(Scanner scanner, String selection) {
        try {
            int selectedNumber = Integer.parseInt(selection);
            if (START > selectedNumber || selectedNumber > MENU_END){
                throw new IllegalArgumentException();
            }
            PathController.pathSearch(scanner);
        } catch (IllegalArgumentException e) {
            if (EXIT_SIGN.contains(selection)) {
                return;
            }
            System.out.println(LineUtils.ERROR_INVALID_TYPE);
        }
    }
}
