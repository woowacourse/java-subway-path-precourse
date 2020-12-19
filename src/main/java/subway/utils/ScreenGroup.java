package subway.utils;

import java.util.Arrays;
import java.util.List;

public enum ScreenGroup {
    MAIN_SCREEN(Arrays.asList(MainScreen.PATH_SEARCH_SCREEN.getCommand(),
        MainScreen.QUIT.getCommand())),
    PATH_CHECK_SCREEN(Arrays.asList(PathSearchScreen.SEARCH_BY_SHORTEST_DISTANCE.getCommand(),
        PathSearchScreen.SEARCH_BY_MINIMUM_TIME.getCommand(),
        PathSearchScreen.BACK.getCommand()));

    private List<String> commands;

    ScreenGroup(List<String> commands) {
        this.commands = commands;
    }

    public boolean hasCommands(String commandCode) {
        return commands.stream()
            .anyMatch(command -> command.equals(commandCode));
    }
}
