package subway;

import subway.common.SelectOption;
import subway.path.PathController;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class SubwayPath {
    private InputView inputView;

    public SubwayPath(InputView inputView) {
        this.inputView = inputView;
    }

    public boolean run() {
        try {
            OutputView.showMainOption();
            List<String> optionList = getMainOptionList();
            String option = SelectOption.askOptionChoice(inputView, optionList);

            if (option.equals(MainOption.PATH.getValue())) {
                PathController pathController = new PathController(inputView);
                pathController.run();
            }
            if (option.equals(MainOption.EXIT.getValue())) {
                return false;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return true;
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
