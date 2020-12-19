package subway.domain;

import subway.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.List;

public enum BasisChoice {

    DISTANCE("1"),
    TIME("2"),
    BACK("B");

    private static List<String> basisCodes = new ArrayList<>();
    private String code;

    BasisChoice(String code) {
        this.code = code;
    }

    public static void validate(String input) throws InvalidInputException {
        if (!isAvailable(input))
            throw new InvalidInputException(InvalidInputException.ExceptionCode.INVALID_FUNCTION_CODE);
    }

    private static boolean isAvailable(String input) {
        initServiceCodes();
        return basisCodes.contains(input);
    }

    private static void initServiceCodes() {
        for (BasisChoice basisChoice : values())
            basisCodes.add(basisChoice.code);
    }
}
