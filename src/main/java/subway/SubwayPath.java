package subway;

import subway.common.SelectOption;
import subway.line.LineController;
import subway.path.PathController;
import subway.station.StationController;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class SubwayPath {
    private StationController stationController;
    private LineController lineController;
    private InputView inputView;

    public SubwayPath(InputView inputView) {
        this.inputView = inputView;
        this.stationController = new StationController();
        this.lineController = new LineController();
    }

    public boolean run() {
        try {
            initialize();
            OutputView.showMainOption();
            List<String> optionList = getMainOptionList();
            String option = SelectOption.askOptionChoice(inputView, optionList);

            if (doProcess(option)) {
                return false;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    private void initialize() {
        stationController.stationInitialize();
        lineController.lineInitialize();
    }

    private boolean doProcess(String option) {
        if (option.equals(MainOption.PATH.getValue())) {
            PathController pathController = new PathController(inputView);
            pathController.run();
        }
        return option.equals(MainOption.EXIT.getValue());
    }

    private List<String> getMainOptionList() {
        MainOption[] options = MainOption.values();
        List<String> optionList = new ArrayList<>();

        for (MainOption option : options) {
            optionList.add(option.getValue());
        }

        return optionList;
    }
}
