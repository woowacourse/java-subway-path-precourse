package subway.controller;

public enum MainScreenFunction {
    PATH_SEARCH("1", "경로 조회"),
    QUIT("Q", "종료");

    private String code;
    private String title;

    MainScreenFunction(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }
}
