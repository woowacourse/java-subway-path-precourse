package subway.view;

import java.util.Scanner;
import subway.utils.ValidateUtils;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }


    public String inputValue() {
        return ValidateUtils.isNotEmpty(scanner.nextLine());
    }
}
