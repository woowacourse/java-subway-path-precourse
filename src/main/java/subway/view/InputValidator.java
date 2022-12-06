package subway.view;

import subway.domain.util.ErrorCode;
import subway.domain.util.MessageFactory;

import java.util.List;

public class InputValidator {
    // 명령어 유효성 관련 상수
    private static final List<String> VALID_MAIN_COMMAND_RANGE = List.of("1", "Q");
    private static final List<String> VALID_DETAIL_COMMAND_RANGE = List.of("1", "2", "B");
    // 역 이름 유효성 관련 상수
    private static final int VALID_NAME_MINIMUM = 3;
    private static final String STATION_NAME_REGEX = "[^가-힣]";
    private static final String NAME_REGEX_REPLACE = "";
    // 노선 이름 유효성 관련 상수
    private static final String LINE_NAME_REGEX = "[^가-힣0-9]";

    private final MessageFactory messageFactory = new MessageFactory();

    void validateMainCommand(String input) {
        if (!VALID_MAIN_COMMAND_RANGE.contains(input)) {
            throw new IllegalArgumentException(messageFactory.makeErrorMessage(ErrorCode.INVALID_COMMAND));
        }
    }

    void validateDetailCommand(String input) {
        if (!VALID_DETAIL_COMMAND_RANGE.contains(input)) {
            throw new IllegalArgumentException(messageFactory.makeErrorMessage(ErrorCode.INVALID_COMMAND));
        }
    }

    String validateStationName(String input) {
        input = input.replaceAll(STATION_NAME_REGEX, NAME_REGEX_REPLACE);
        if (input.length() < VALID_NAME_MINIMUM) {
            throw new IllegalArgumentException(messageFactory.makeErrorMessage(ErrorCode.INVALID_STATION_NAME));
        }
        return input;
    }

}