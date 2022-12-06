package subway.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String COMMAND_MESSAGE = "## 원하는 기능을 선택하세요.";

    private static final InputValidator inputValidator = new InputValidator();

    public static String readMainCommand() {
        System.out.println();
        System.out.println(COMMAND_MESSAGE);

        String input = Console.readLine();
        inputValidator.validateMainCommand(input);
        return input;
    }

    public static String readDetailCommand() {
        System.out.println();
        System.out.println(COMMAND_MESSAGE);

        String input = Console.readLine();
        inputValidator.validateDetailCommand(input);
        return input;
    }

}