package subway.domain;

import subway.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.List;

public enum FunctionChoice {

    PATH("1"),
    QUIT("Q");

    private static List<String> functionCodes = new ArrayList<>();
    private String code;

    FunctionChoice(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static void validate(String input) throws InvalidInputException {
        if (!isAvailable(input))
            throw new InvalidInputException(InvalidInputException.ExceptionCode.INVALID_FUNCTION_CODE);
    }

    private static boolean isAvailable(String input) {
        initServiceCodes();
        return functionCodes.contains(input);
    }

    private static void initServiceCodes() {
        for (FunctionChoice functionChoice : FunctionChoice.values())
            functionCodes.add(functionChoice.code);
    }
}
