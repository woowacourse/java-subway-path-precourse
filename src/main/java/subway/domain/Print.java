package subway.domain;

import java.util.List;

public class Print {
    public static void menu(String title, List<String> itemList) {
        System.out.println(Constant.HEAD_HASH + title);
        for (int i = 0; i < itemList.size(); i++) {
            System.out.println(itemList.get(i));
        }
    }

    public static void hashMessage(String text) {
        System.out.println(Constant.HEAD_HASH + text);
    }

    public static void infoMessage(String text) {
        System.out.println(Constant.HEAD_INFO + text);
    }
}
