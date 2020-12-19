package subway.view.output;

import java.util.List;

public class OutputView {
    public static StringBuilder stringBuilder = new StringBuilder();
    protected static String MENU_SYMBOL = "\n## ";
    protected static String INFO_SYMBOL = "\n[INFO] ";
    protected static String SELECT_MENU = "원하는 기능을 선택하세요.\n";

    protected static void menuSymbol() {
        stringBuilder.append(MENU_SYMBOL);
    }

    static void print() {
        System.out.print(stringBuilder.toString());
        resetStringBuilder();
    }

    private static void resetStringBuilder() {
        stringBuilder.setLength(0);
    }

    protected static void printMenu(String VIEW_NAME, List<String> menuList) {
        menuSymbol();
        stringBuilder.append(VIEW_NAME);
        menuList.forEach(menu -> stringBuilder.append(menu));
        print();
    }

    public void selectMenu() {
        menuSymbol();
        stringBuilder.append(SELECT_MENU);
        print();
    }
}
