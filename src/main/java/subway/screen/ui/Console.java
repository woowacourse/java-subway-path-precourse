package subway.screen.ui;

import java.io.PrintStream;
import java.util.Scanner;

public final class Console {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PrintStream printer = System.out;

    private static final String HEADER_OUTPUT_FORMAT = "## %s";
    private static final String INFO_OUTPUT_FORMAT = "[INFO] %s";
    private static final String ERROR_OUTPUT_FORMAT = "[ERROR] %s";

    public static String readline() {
        return scanner.nextLine();
    }

    public static void println() {
        printer.println();
    }

    public static void println(String message) {
        printer.println(message);
    }

    public static void printHeader(String message) {
        println(String.format(HEADER_OUTPUT_FORMAT, message));
    }

    public static void printInfo(String message) {
        println(String.format(INFO_OUTPUT_FORMAT, message));
    }

    public static void printError(String message) {
        println(String.format(ERROR_OUTPUT_FORMAT, message));
    }

}
