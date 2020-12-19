package subway;

import subway.domain.data.Line;
import subway.domain.data.LineRepository;
import subway.domain.data.Station;
import subway.domain.data.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SubwayPath {

    private Scanner scanner;

    public SubwayPath(Scanner scanner) {
        this.scanner = scanner;
        InitData.initData();
        run();
    }

    private void run() {
        OutputView.printMainView();
        String order = selectMenu();
        selectPathRuleMenu(order);
    }

    private void selectPathRuleMenu(String order) {
        OutputView.printPathRuleView();
    }

    private String selectMenu() {
        try {
            OutputView.printAskingFunction();
            return InputView.getMainMenu(scanner);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return selectMenu();
        }
    }

}
