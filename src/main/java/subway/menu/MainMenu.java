package subway.menu;

public enum MainMenu {
    PATH_SERVICE("1","1. 경로 조회"), EXIT("Q", "Q. 종료");

    private final String option;
    private final String message;

    MainMenu(String option, String message) {
        this.option = option;
        this.message = message;
    }
    
    public String getOption() {
        return option;
    }

    public String getMessage() {
        return message;
    }
}
