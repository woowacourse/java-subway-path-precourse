package subway.screen.view.path;

import subway.screen.view.Menu;

public enum PathMenu implements Menu {
    SHORT_DISTANCE("1", "최단 거리"),
    SHORT_TIME("2", "최소 시간"),
    BACK("B", "돌아가기");

    private final String command;
    private final String name;

    PathMenu(String command, String name) {
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
