package subway.controller;

import java.util.Scanner;

import subway.domain.LineRepository;
import subway.domain.ShortenPathDTO;
import subway.service.SubwayUtils;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayControlelr {

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
                String startStation = inputView.askStartStation();
                String endStation = inputView.askEndStation();

                ShortenPathDTO shortenPathDTO = SubwayUtils.findShortenPathByDistance(startStation, endStation);
                outputView.showPath(shortenPathDTO);
            } else if (directionInput.equals("2")) {
                String startStation = inputView.askStartStation();
                String endStation = inputView.askEndStation();

                ShortenPathDTO shortenPathDTO = SubwayUtils.findShortenPathByTime(startStation, endStation);
                outputView.showPath(shortenPathDTO);
            }

            run();
        }
    }
}
