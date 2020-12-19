package subway.domain;

import subway.error.SubwayErrorMessage;
import subway.view.FunctionView;
import subway.view.InputView;
import subway.view.MainView;
import subway.view.OutputView;

public class StationManager {
    private static final SubwayAgency subwayAgency = new SubwayAgency(new SubwayMap(LineRepository.lines()));

    public static void start() {
        MainView main = main();
        if (main != MainView.QUIT) {
            function();
            start();
        }
    }

    public static MainView main() {
        OutputView.printMainView();
        return InputView.getMain();
    }

    public static void function() {
        OutputView.printFunction();
        FunctionView function = InputView.getFunction();
        execute(function);
    }


    public static void execute(FunctionView functionView) {
        try {
            functionView.execute(new StationManager());
        } catch (IllegalArgumentException e) {
            OutputView.printError(SubwayErrorMessage.IMPOSSIBLE_FIND.getMessage());
            function();
        }
    }

    public void byDistance() {
        StationBetween stationBetween = InputView.getStationBetween();
        GraphResult resultByDistance = subwayAgency.getResultByDistance(stationBetween);
        OutputView.printResult(resultByDistance);
    }

    public void byTime() {
        StationBetween stationBetween = InputView.getStationBetween();
        GraphResult resultByTime = subwayAgency.getResultByTime(stationBetween);
        OutputView.printResult(resultByTime);
    }
}
