package subway.view;

import subway.MainOption;

public class OutputView {
    private static final String MAIN_TITLE = "## 메인 화면";
    private static final String DOT = ". ";
    private static final String SELECT_OPTION = "## 원하는 기능을 선택하세요.";

    public static void showMainOption() {
        System.out.println(MAIN_TITLE);
        for (MainOption option : MainOption.values()) {
            System.out.print(option.getValue() + DOT);
            System.out.println(option.getDescription());
        }
        System.out.println();
    }

    public static void askMainOptionChoice() {
        System.out.println(SELECT_OPTION);
    }
}
