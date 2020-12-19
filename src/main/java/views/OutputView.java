package views;

import subway.Category.Category;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String PRINT_INFO = "[INFO] ";
    private static final String SEPARATOR = "[INFO] --- \n";

    public static void mainView() {
        System.out.println(Category.MAIN.getName());
        System.out.println(Category.MAIN.getActionOrder());

    }

    public static void path_standardView() {
        System.out.println(Category.ROUTE.getName());
        System.out.println(Category.ROUTE.getActionOrder());
    }

    public static void path_lookup_result() {
        System.out.println("\n## 조회 결과");
    }
}
