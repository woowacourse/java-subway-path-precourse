package subway.input;

import java.util.Scanner;

/**
 * @author yhh1056
 * @since 2020/12/19
 */
public class InputView {
    private static final String CHOICE_FUNCTION_BUTTON = "\n## 원하는 기능을 선택하세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputFunctionButton() {
        System.out.println(CHOICE_FUNCTION_BUTTON);
        return scanner.nextLine();
    }
}
