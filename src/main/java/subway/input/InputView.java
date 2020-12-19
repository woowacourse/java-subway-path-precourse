package subway.input;

import java.util.Scanner;

/**
 * @author yhh1056
 * @since 2020/12/19
 */
public class InputView {
    private static final String CHOICE_FUNCTION_BUTTON = "\n## 원하는 기능을 선택하세요.";
    private static final String INPUT_START_STATION = "\n## 출발역을 입력하세요.";
    private static final String INPUT_FINISH_STATION = "\n## 도착역을 입력하세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputFunctionButton() {
        System.out.println(CHOICE_FUNCTION_BUTTON);
        return scanner.nextLine();
    }

    public static String inputStartStation() {
        System.out.println(INPUT_START_STATION);
        return scanner.nextLine();
    }

    public static String inputFinishStation() {
        System.out.println(INPUT_FINISH_STATION);
        return scanner.nextLine();
    }
}
