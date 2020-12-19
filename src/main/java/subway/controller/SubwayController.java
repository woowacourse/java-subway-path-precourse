package subway.controller;

import java.util.Arrays;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.SubwayException;
import subway.menu.MainMenu;
import subway.menu.PathMenu;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {

    private static final String[] initialStations = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역",
        "양재시민의숲역", "매봉역"};
    private static final String[] initialLines = {"2호선", "3호선", "신분당선"};
    private static final String LineTwo = "2호선";
    private static final String LineThree = "3호선";
    private static final String LineSinBunDang = "신분당선";
    private final InputView inputView;

    public SubwayController(InputView inputView) {
        this.inputView = inputView;
    }


    public void run() {
        initializeSubway();
        MainMenu.startManage();
        printMainCategory();
    }

    private void initializeSubway() {
        Arrays.stream(initialStations)
            .forEach(station -> StationRepository.addStation(new Station(station)));
        Arrays.stream(initialLines)
            .forEach(line -> LineRepository.addLine(new Line(line)));
        initialLineTwo();
        initialLineThree();
        initialLineSinBunDang();
    }

    private void initialLineSinBunDang() {
        Line sinBunDang = LineRepository.findLine(LineSinBunDang);
        sinBunDang.addByName("강남역");
        sinBunDang.addByName("양재역");
        sinBunDang.addByName("양재시민의숲역");
    }

    private void initialLineThree() {
        Line three = LineRepository.findLine(LineThree);
        three.addByName("교대역");
        three.addByName("남부터미널역");
        three.addByName("양재역");
        three.addByName("매봉역");

    }

    private void initialLineTwo() {
        Line two = LineRepository.findLine(LineTwo);
        two.addByName("교대역");
        two.addByName("강남역");
        two.addByName("역삼역");
    }

    private void printMainCategory() {
        OutputView.chooseCategory();
        try {
            MainMenu.execute(inputView.inputValue());
        } catch (SubwayException exception) {
            OutputView.showErrorMessage(exception);
            printMainCategory();
        }
    }

    public static void startPathMenu() {
        PathMenu.startManage();
        printPathCategory();
    }

    private static void printPathCategory() {
        OutputView.chooseCategory();
        try {
            MainMenu.execute(inputView.inputValue());
        } catch (SubwayException exception) {
            OutputView.showErrorMessage(exception);
            printPathCategory();
        }
    }

    public static void findMinimumDistance() {
        OutputView.printStartStation();
        OutputView.printEndStation();
        OutputView.printResult();
    }

    public static void findMinimumTime() {
        OutputView.printStartStation();
        OutputView.printEndStation();
        OutputView.printResult();
    }
}
