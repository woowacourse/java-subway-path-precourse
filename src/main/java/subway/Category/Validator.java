package subway.Category;

import subway.Exception.NotValidFunctionException;

import java.util.List;

public class Validator {
    public static void isValidCategory(String input, List<String> actionType) {
        if (!actionType.contains(input))
            throw new NotValidFunctionException();
    }
}
