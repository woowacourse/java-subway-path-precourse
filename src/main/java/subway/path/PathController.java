package subway.path;

import subway.MainOption;
import subway.common.SelectOption;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class PathController {
    private InputView inputView;

    public PathController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        while (true) {
            OutputView.showSearchPathMethod();
            List<String> optionList = getSearchOptionList();
            String method = SelectOption.askOptionChoice(inputView, optionList);
            break;
        }
    }

    private List<String> getSearchOptionList() {
        SearchMethod[] methods = SearchMethod.values();
        List<String> optionList = new ArrayList<>();

        for (SearchMethod method : methods) {
            optionList.add(method.getValue());
        }

        return optionList;
    }
}
