package subway.utils;

import java.util.Arrays;
import java.util.function.Function;

import subway.controller.PathController;
import subway.view.InputView;
import subway.view.OutputView;

public enum PathSearchScreen {
    SEARCH_BY_SHORTEST_DISTANCE("1", inputView -> {
        String departureStationName = inputView
            .getStationName(OutputView.ORDER_TO_INPUT_DEPARTURE_STATION);
        String arrivalStationName = inputView
            .getStationName(OutputView.ORDER_TO_INPUT_ARRIVAL_STATION);
        return PathController.searchPathByShortestDistance(departureStationName,arrivalStationName);
    }),
    SEARCH_BY_MINIMUM_TIME("2", inputView -> {
        String departureStationName = inputView
            .getStationName(OutputView.ORDER_TO_INPUT_DEPARTURE_STATION);
        String arrivalStationName = inputView
            .getStationName(OutputView.ORDER_TO_INPUT_ARRIVAL_STATION);
        return true;
    }),
    BACK("B", inputView -> false);

    private String command;
    private Function<InputView, Boolean> function;

    PathSearchScreen(String command,
        Function<InputView, Boolean> function) {
        this.command = command;
        this.function = function;
    }

    public static boolean run(InputView inputView, String commandcode) {
        if (hasCommand(commandcode)) {
            return Arrays.stream(values())
                .filter(pathSearchScreen -> pathSearchScreen.command.equals(commandcode))
                .findAny()
                .orElse(PathSearchScreen.BACK)
                .function.apply(inputView);
        }
        return true;
    }

    public static boolean hasCommand(String commandcode) {
        return Arrays.stream(values())
            .anyMatch(pathSearchScreen -> pathSearchScreen.command.equals(commandcode));
    }

    public String getCommand() {
        return command;
    }
}
