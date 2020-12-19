package subway.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private InputView() {
    }

    public static String getAnswer() {
        return scanner.nextLine().strip();
    }

    public static String getStation() {
        return scanner.nextLine().strip();
    }



}
