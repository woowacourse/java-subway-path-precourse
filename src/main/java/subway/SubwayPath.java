package subway;

import subway.domain.data.Station;
import subway.domain.data.StationRepository;
import subway.menu.MainMenu;
import subway.view.InputView;
import subway.view.OutputView;
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
        String mainOrder = selectMenu();

        if(mainOrder.equals(MainMenu.END.getOrder())){
            return;
        }

        String pathRuleOrder = selectPathRuleMenu();
        String startingStation = getStationName(Station.POINT.STARTING);
        String endingStation = getStationName(Station.POINT.ENDING);
    }

    private String getStationName(Station.POINT point){
        try {
            OutputView.printAskingStation(point);
            return InputView.getStationName(scanner);
        } catch (IllegalArgumentException e){
            OutputView.printError(e.getMessage());
            return getStationName(point);
        }
    }

    private String selectPathRuleMenu() {
        try {
            OutputView.printPathRuleView();
            OutputView.printAskingFunction();
            return InputView.getPathRuleMenu(scanner);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return selectPathRuleMenu();
        }
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
