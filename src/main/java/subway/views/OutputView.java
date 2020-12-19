package subway.views;

public interface OutputView {
    String LINE_WRAP = "\n";
    String SELECT_FEATURE_MESSAGE = "## 원하는 기능을 선택하세요.";

    static void printSelectOptionMessage() {
        System.out.println(LINE_WRAP + SELECT_FEATURE_MESSAGE);
    }
}
