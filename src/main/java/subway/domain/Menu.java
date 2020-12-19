package subway.domain;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private String title;
    private List<String> itemList;

    public Menu(String title, List<String> itemList) {
        this.title = title;
        this.itemList = itemList;
    }

    public String load(Scanner scanner) {
        Print.menu(this.title, this.itemList);
        System.out.println();
        while (true) {
            try {
                Print.hashMessage(Constant.CHOOSE_FUNCTION);
                String input = scanner.next();
                System.out.println();
                return Exceptions.isInMenu(input, this.itemList);
            } catch (IllegalArgumentException e) {
                System.out.printf(e.getMessage() + "%n%n");
            }
        }
    }
}
