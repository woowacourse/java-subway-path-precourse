package subway.domain;

import java.util.List;

public class Exceptions {
    static String isInMenu(String input, List<String> menuItemList) {
        for (int i = 0; i < menuItemList.size(); i++) {
            String number = menuItemList.get(i).substring(0, 1);
            if (input.equals(number)) {
                return input;
            }
        }
        throw new IllegalArgumentException(Constant.HEAD_ERROR + Constant.IS_IN_MENU);
    }
}
