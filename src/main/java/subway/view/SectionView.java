package subway.view;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
import subway.menu.SectionMenu;

public class SectionView extends View {
    private static final String TITLE = "경로 기준";

    public SectionView(Scanner scanner, PrintStream printStream) {
        super(scanner, printStream);
    }

    @Override
    void printTitle() {
        printStream.printf(TITLE_FORM, TITLE);
    }

    @Override
    void printMenuList() {
        Arrays.asList(SectionMenu.values()).stream()
                .forEach(menu -> printStream.printf(MENU_FORM, menu.getKey(), menu.getMessage()));
        printStream.println();
    }
}
