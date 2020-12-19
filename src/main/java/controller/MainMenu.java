package controller;

enum MainMenu {
    INQUIRY_PATH("1", "경로 조회"), EXIT_PROGRAM("2", "종료");

    public static final String MENU_NAME = "## 메인 화면";

    private String value;
    private String action;

    private MainMenu(String value, String action) {
        this.value = value;
        this.action = action;
    }

    public String getValue() {
        return value;
    }

    public String getAction() {
        return action;
    }
}
