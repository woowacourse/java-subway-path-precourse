package subway.view;

import java.util.Scanner;
import utils.LineUtils;

public class InputView {

    public static String inputSelection(Scanner scanner) {
        System.out.println(LineUtils.ASK_SELECTION);
        return scanner.nextLine();
    }

    public static String inputStationName(Scanner scanner, String line) {
        System.out.println(line);
        return scanner.nextLine();
    }
}
