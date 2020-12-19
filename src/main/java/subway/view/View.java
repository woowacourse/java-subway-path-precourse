package subway.view;

import java.io.PrintStream;
import java.util.Scanner;
import subway.Error;

public abstract class View {
    private static final String ERROR_FORM = "[ERROR] %s\n";
    protected static final String TITLE_FORM = "## %s\n";
    protected static final String MENU_FORM = "%s. %s\n";
    protected final Scanner scanner;
    protected final PrintStream printStream;
    
    protected View(Scanner scanner, PrintStream printStream) {
        this.scanner = scanner;
        this.printStream = printStream;
    }
    
    abstract void printTitle();
    abstract void printMenuList();
    
    public String requestMenu() {
        printTitle();
        printMenuList();
        String input = scanner.nextLine();
        printStream.println();
        return input;
    }
    
    public void printError(Error error) {
        printStream.printf(ERROR_FORM, error.getMessage());
        printStream.println();
    }
}
