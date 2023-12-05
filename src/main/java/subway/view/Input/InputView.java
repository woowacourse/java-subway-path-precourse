package subway.view.Input;

import subway.validation.EndStationValidation;
import subway.validation.MainFunctionValidation;
import subway.validation.SelectRouteValidation;
import subway.validation.StartStationValidation;

public class InputView {
    private final MainFunctionValidation mainFunctionValidation;
    private final SelectRouteValidation selectRouteValidation;
    private final StartStationValidation startStationValidation;
    private final EndStationValidation endStationValidation;

    public InputView(MainFunctionValidation mainFunctionValidation, SelectRouteValidation selectRouteValidation,
                     StartStationValidation startStationValidation, EndStationValidation endStationValidation) {
        this.mainFunctionValidation = mainFunctionValidation;
        this.selectRouteValidation = selectRouteValidation;
        this.startStationValidation = startStationValidation;
        this.endStationValidation = endStationValidation;
    }

    public String readMainFunc(String input) {
        return mainFunctionValidate(input);
    }

    public String readSelectRoute(String input) {
        return selectRouteValidate(input);
    }

    public String readStartStation(String input) {
        return startStationValidate(input);
    }

    public String readEndStation(String start, String input) {
        return endStationValidate(start, input);
    }

    private String mainFunctionValidate(String input) {
        mainFunctionValidation.isBlank(input);
        return mainFunctionValidation.isOneOrQ(input);
    }

    private String selectRouteValidate(String input) {
        selectRouteValidation.isBlank(input);
        return selectRouteValidation.isOneOrTwoOrB(input);
    }

    private String startStationValidate(String input) {
        startStationValidation.isBlank(input);
        return startStationValidation.isRegister(input);
    }

    private String endStationValidate(String start, String input) {
        endStationValidation.isBlank(input);
        endStationValidation.isRegister(input);
        return endStationValidation.isDuplicate(start, input);
    }
}

