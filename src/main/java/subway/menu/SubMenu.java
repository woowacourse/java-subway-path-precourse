package subway.menu;

import java.util.List;

import subway.controller.Init;
import subway.domain.NotExistPathException;
import subway.domain.StationGraph;
import subway.view.InputView;
import subway.view.OutputView;

public class SubMenu implements Menu {
    public static final String MINIMUM_DISTANCE = "1";
    public static final String MINIMUM_TIME = "2";
    public static final String BACK_MENU_SEL = "B";
    private InputView inputView;

    public SubMenu(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public void printMenu() {
        OutputView.printSubDisplay();
    }

    @Override
    public String inputMenu() {
        return inputView.inputSubMenu();
    }

    @Override
    public void runMenu() {
        printMenu();
        String selMenu = inputMenu();

        if (selMenu.equals(BACK_MENU_SEL)) {
            return;
        }

        if (selMenu.equals(MINIMUM_DISTANCE)) {
            getMinimumDistance();
        }

        if (selMenu.equals(MINIMUM_TIME)) {
            getMinimumTime();
        }
    }

    private String inputStation() {
        return inputView.inputDepartureStation();
    }

    private String inputStation(String departureStation) {
        return inputView.inputArrivalStation(departureStation);
    }

    private void getMinimumDistance() {
        String depatureStation = inputStation();
        String arrivalStation = inputStation(depatureStation);
        List<Integer> res = StationGraph.dijkstra(Init.findStationNumber(depatureStation),
                Init.findStationNumber(arrivalStation));

        if (res.get(0) == Integer.MAX_VALUE) {
            OutputView.printErrorMessage(new NotExistPathException());
            return;
        }
        OutputView.printSuccessDisplay(res.get(0), res.get(1));
    }

    private void getMinimumTime() {
        String depatureStation = inputStation();
        String arrivalStation = inputStation(depatureStation);
        List<Integer> res = StationGraph.dijkstraTime(Init.findStationNumber(depatureStation),
                Init.findStationNumber(arrivalStation));

        if (res.get(1) == Integer.MAX_VALUE) {
            OutputView.printErrorMessage(new NotExistPathException());
            return;
        }
        OutputView.printSuccessDisplay(res.get(0), res.get(1));
    }
}
