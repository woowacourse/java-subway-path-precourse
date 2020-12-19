package subway.view;

import subway.MainOption;
import subway.view.validation.NotExistOption;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String selectOption(List<MainOption> optionList) {
        String option = scanner.next();
        NotExistOption.validate(option, optionList);
        return option;
    }
}
