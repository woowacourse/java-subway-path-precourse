package subway.screen.view.main;

import subway.screen.view.Menu;

public enum MainMenu implements Menu {
    PATH_SEARCH("1", "경로 조회"), END("Q", "종료");

    private final String command;
    private final String name;

    MainMenu(String command, String name) {
        this.command = command;
        this.name = name;
    }

    @Override
    public String getCommand() {
        return this.command;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
