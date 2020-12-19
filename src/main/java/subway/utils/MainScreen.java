package subway.utils;

import java.util.Arrays;
import java.util.function.Supplier;
import subway.Router;

public enum MainScreen {
    PATH_SEARCH_SCREEN("1", Router::enterPathSearchScreen),
    QUIT("Q", () -> false);

    private String command;
    private Supplier<Boolean> function;

    MainScreen(String command, Supplier<Boolean> function) {
        this.command = command;
        this.function = function;
    }

    public static boolean run(String commandCode) {
        if (hasFeature(commandCode)) {
            return Arrays.stream(values())
                .filter(mainScreen -> mainScreen.command.equals(commandCode))
                .findAny()
                .orElse(MainScreen.QUIT)
                .function.get();
        }
        return true;
    }

    public static boolean hasFeature(String commandCode) {
        return Arrays.stream(values())
            .anyMatch(mainScreen -> mainScreen.command.equals(commandCode));
    }

    public String getCommand() {
        return command;
    }
}
