package subway.view;

import java.util.Scanner;
import subway.domain.selector.Selector;
import subway.domain.selector.menu.Menu;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static Selector getSelector(Menu menu) {
        try {
            System.out.println("## 원하는 기능을 선택하세요.");
            String input = scanner.nextLine();
            validateMenuId(menu, input);
            if (menu.getMenus().get(input) != null) {
                return menu.getMenus().get(input);
            }
            return menu.getItems().get(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            OutputView.printScreen(menu);
            return getSelector(menu);
        }
    }


    private static void validateMenuId(Menu menu, String id) {
        if (!menu.isIdContain(id)) {
            throw new IllegalArgumentException("[ERROR] 올바른 메뉴를 선택해주세요.");
        }
    }
}
