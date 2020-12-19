package subway.domain;

import subway.view.ErrorMessage;

import java.util.List;

public class Errors {
    public static void checkInput(String input, List<String> functions) {
        if (!functions.contains(input)) {
            ErrorMessage.displayErrorMessage(Constants.FUNCTION_INPUT_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public static void checkExistStation(String name) {
        if (!StationRepository.isExist(name)) {
            ErrorMessage.displayErrorMessage(Constants.NO_SUCH_NAME_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public static void checkSameName(String firstName, String lastName) {
        if (firstName.equals(lastName)) {
            ErrorMessage.displayErrorMessage(Constants.SAME_NAME_ERROR);
            throw new IllegalArgumentException();
        }
    }
}
