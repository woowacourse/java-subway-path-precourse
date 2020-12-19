package subway.utils;

import java.util.Arrays;
import java.util.function.Function;

import subway.view.InputView;

public enum PathSearchScreen {
    SEARCH_BY_SHORTEST_DISTANCE("1", inputView -> {
        System.out.println("abdc");
        return true;
    }),
    SEARCH_BY_MINIMUM_TIME("2", inputView ->  true),
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
