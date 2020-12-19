package subway.view;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
import subway.menu.MainMenu;

public class MainView extends View {
    private static final String TITLE = "메인 화면";

    public MainView(Scanner scanner, PrintStream printStream) {
        super(scanner, printStream);
    }

    @Override
    void printTitle() {
        printStream.printf(TITLE_FORM, TITLE);
    }

    @Override
    void printMenuList() {
        Arrays.asList(MainMenu.values()).stream()
                .forEach(menu -> printStream.printf(MENU_FORM, menu.getKey(), menu.getMessage()));
        printStream.println();
    }

}
