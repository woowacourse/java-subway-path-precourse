package subway.view;

import subway.MainOption;

public class OutputView {
    private static final String MAIN_TITLE = "## 메인 화면";
    private static final String DOT = ". ";

    public static void showMainOption() {
        System.out.println(MAIN_TITLE);
        for (MainOption option : MainOption.values()) {
            System.out.print(option.getValue() + DOT);
            System.out.println(option.getDescription());
        }
    }
}
