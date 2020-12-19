package subway.menu;

import subway.exception.SubwayException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum MainMenu {
    SHOW_PATH("경로 조회", "1"),
    QUIT("종료", "Q");

    MainMenu(String title, String command) {
        this.title = title;
        this.command = command;
    }

    private final String title;
    private final String command;

    public static MainMenu findByCommand(String command) {
        return Arrays.stream(MainMenu.values())
                .filter(mainMenu -> mainMenu.command.equalsIgnoreCase(command))
                .findAny()
                .orElseThrow(() -> {
                    throw new SubwayException("해당 메뉴가 없습니다.");
                });
    }

    public static List<String> getTitles() {
        return Arrays.stream(MainMenu.values())
                .map(mainMenu -> mainMenu.title)
                .collect(Collectors.toList());
    }

    public static List<String> getCommands() {
        return Arrays.stream(MainMenu.values())
                .map(mainMenu -> mainMenu.command)
                .collect(Collectors.toList());
    }
}
