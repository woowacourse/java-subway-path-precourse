package subway.view.constants;

public enum MainInputOption {
    INITIAL_BLANK(""),
    MAIN_SCREEN("## 메인화면"),
    CHECK_PATH("1. 경로 조회"),
    QUIT("Q. 종료"),
    BLANK(""),
    ASK("## 원하시는 기능을 선택하세요.");

    final private String message;

    private MainInputOption(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

