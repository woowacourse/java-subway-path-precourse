package subway.view;

import subway.domain.util.ErrorCode;
import subway.domain.util.MessageFactory;

import java.util.List;

public class InputValidator {
    private static final List<String> VALID_MAIN_COMMAND_RANGE = List.of("1", "Q");
    private static final List<String> VALID_DETAIL_COMMAND_RANGE = List.of("1", "2", "B");

    private final MessageFactory messageFactory = new MessageFactory();

    void validateMainCommand(String input) {
        if (!VALID_MAIN_COMMAND_RANGE.contains(input)) {
            throw new IllegalArgumentException(messageFactory.makeErrorMessage(ErrorCode.INVALID_COMMAND));
        }
    }

    public void validateDetailCommand(String input) {
        if (!VALID_DETAIL_COMMAND_RANGE.contains(input)) {
            throw new IllegalArgumentException(messageFactory.makeErrorMessage(ErrorCode.INVALID_COMMAND));
        }
    }

}