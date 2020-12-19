package subway.controller;

import java.util.Scanner;
import java.util.function.BiFunction;

import subway.domain.LineRepository;
import subway.domain.ShortenPathDTO;
import subway.service.SubwayUtils;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayControlelr {

    public static final String SAME_END_STATION_ERROR = "[ERROR] 출발역과 도착역이 동일합니다.";

    private final LineRepository lineRepository;

    private final InputView inputView;

    private final OutputView outputView;

    public SubwayControlelr(final Scanner scanner) {
        this.lineRepository = SubwayUtils.initialize();
        this.inputView = new InputView(scanner);
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.showMain();

        String mainInput = inputView.askFunction();

        if (mainInput.equals("1")) {
            outputView.showDirection();

            String directionInput = inputView.askFunction();

            if (directionInput.equals("1")) {
                functionDirection(SubwayUtils::findShortenPathByDistance);
            } else if (directionInput.equals("2")) {
                functionDirection(SubwayUtils::findShortenPathByTime);
            }

            run();
        }
    }

    private void functionDirection(BiFunction<String, String, ShortenPathDTO> biFunction) {
        String startStation = inputView.askStartStation();
        String endStation = inputView.askEndStation();

        if (startStation.equals(endStation)) {
            throw new IllegalArgumentException(SAME_END_STATION_ERROR);
        }

        ShortenPathDTO shortenPathDTO = biFunction.apply(startStation, endStation);
        outputView.showPath(shortenPathDTO);
    }
}
