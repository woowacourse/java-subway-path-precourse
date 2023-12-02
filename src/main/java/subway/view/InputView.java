package subway.view;

import subway.util.message.InputMessage;
import subway.view.validator.MenuValidator;
import subway.view.validator.StationValidator;
import subway.view.validator.Validator;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static Scanner scanner;
    public static void init(Scanner sc){
        scanner = sc;
    }

    public static String inputKey(List<String> candidateKeys){
        System.out.println(InputMessage.SELECT_WANTED.getValue());
        return MenuValidator.validate(scanner.next(), candidateKeys);
    }

    public static String inputStation(final String str){
        System.out.println(str);
        String input = scanner.next();
        StationValidator.validate(input);
        return input;
    }
}
