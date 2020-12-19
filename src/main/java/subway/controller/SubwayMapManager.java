package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayMapManager {
    InputView inputView;
    OutputView outputView;

    public SubwayMapManager(Scanner scanner) {
        this.inputView = new InputView(scanner);
        this.outputView = new OutputView();
    }

    public void startManager() {
        outputView.mainView();
        outputView.getUserOption();
        String option = inputView.userInput();
        routeMainOption(option);
    }

    private void routeMainOption(String option) {
        if (option.equals("1")) {

        }
        if (option.equals("Q")) {
            return;
        }
    }

    public void startPathFind() {
        outputView.mapView();
        outputView.getUserOption();
        String option = inputView.userInput();
        routeMapOption(option);
    }

    private void routeMapOption(String option) {
        if (option.equals("1")) {
            // 최단 거리
        }
        if (option.equals("2")) {
            // 최소 시간
        }
        if (option.equals("B")) {
            // 돌아가기
            startManager();
        }
    }
}
