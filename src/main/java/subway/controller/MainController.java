package subway.controller;

import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class MainController {

    private InputView inputView;
    private OutputView outputView;

    public MainController(Scanner scanner) {
        initData();
        initViews(scanner);
    }

    private void initData() {
        StationRepository.initStations();
        LineRepository.initLines();
    }

    private void initViews(Scanner scanner) {
        inputView = new InputView(scanner);
        outputView = new OutputView();
    }

    public void run() {

    }
}
