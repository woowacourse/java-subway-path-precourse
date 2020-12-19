package subway.view;

import java.util.Scanner;

public class SubwayView {
    private static final String NOTICE_PREFIX = "## ";
    private static final String INFO_PREFIX = "[INFO] ";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String MAIN_SCREEN = "";
    private Scanner scanner;

    public SubwayView(Scanner scanner) {
        this.scanner = scanner;
    }
}
