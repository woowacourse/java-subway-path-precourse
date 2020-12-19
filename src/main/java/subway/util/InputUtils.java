package subway.util;

import java.util.Scanner;
import java.util.Set;
import subway.exception.CommandException;
import subway.exception.InputIsNotInList;

public class InputUtils {

    private final Scanner scanner;

    public InputUtils(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getNextLine() {
        return scanner.nextLine();
    }

    public static boolean checkValidInput(String input, Set<String> functionSet) {
        try {
            if (!functionSet.contains(input)) {
                throw new InputIsNotInList();
            }
        } catch (CommandException e) {
            e.printError();
            return true;
        }
        return false;
    }
}
