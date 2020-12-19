package subway.enums.menu;

public enum MainMenu {
    TITLE("## 메인 화면", "0"),
    SEARCH_ROUTE("1. 경로 조회", "1"),
    EXIT("Q. 종료", "Q");

    private String menu;
    private String command;

    MainMenu(String menu, String command) {
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
