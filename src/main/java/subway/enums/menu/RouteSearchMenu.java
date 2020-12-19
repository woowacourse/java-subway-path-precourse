package subway.enums.menu;

public enum RouteSearchMenu {
    TITLE("## 경로 기준", "0"),
    SHORTEST_DISTANCE("1. 최단 거리", "1"),
    MINIMUM_TIME("2. 최소 시간", "2"),
    BACK("B. 돌아가기", "B");

    private String menu;
    private String command;

    RouteSearchMenu(String menu, String command) {
        this.menu = menu;
        this.command = command;
    }

    public String getMenu() {
        return menu;
    }

    public String getCommand() {
        return command;
    }
}
