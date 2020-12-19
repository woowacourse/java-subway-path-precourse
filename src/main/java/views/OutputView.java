package views;

import subway.Category.Category;

public class OutputView {

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
