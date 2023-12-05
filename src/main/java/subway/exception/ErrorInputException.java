package subway.exception;

public class ErrorInputException extends RuntimeException {
    public enum ErrorMessage {
        MAIN_FUNCTION_CANNOT_BE_NULL_OR_EMPTY("메인 화면 기능 선택은 빈 값이거나 null 값 일 수 없습니다. 다시 입력해주세요."),
        MAIN_FUNCTION_MUST_BE_ONE_OR_Q("메인 화면 기능 선택은 1 또는 Q 값만 입력 가능합니다. 다시 입력해주세요."),

        SELECT_ROUTE_CANNOT_BE_NULL_OR_EMPTY("경로 선택 기능은 빈 값이거나 null 값 일 수 없습니다. 다시 입력해주세요."),
        SELECT_ROUTE_MUST_BE_ONE_OR_OR_TWO_OR_B("경로 선택 기능은 1 또는 2 또는 B 값만 입력 가능합니다. 다시 입력해주세요."),

        START_STATION_CANNOT_BE_NULL_OR_EMPTY("출발역은 빈 값이거나 null 값 일 수 없습니다. 다시 입력해주세요."),

        END_STATION_CANNOT_BE_NULL_OR_EMPTY("도착역은 빈 값이거나 null 값 일 수 없습니다. 다시 입력해주세요."),

        IS_NOT_REGISTERED("등록되지 않은 역입니다. 다시 입력해주세요."),

        START_AND_END_ARE_DUPLICATE("출발역과 도착역이 동일합니다."),

        NOT_CONNECTED(" 출발역과 도착역이 연결되어 있지 않습니다.");


        ErrorMessage(final String message) {
            this.message = message;
        }

        private final String errorMessage = "[ERROR] ";

        private final String message;

        public String getErrorMessage() {
            return errorMessage;
        }

        public String getMessage() {
            return message;
        }

    }

    public ErrorInputException(ErrorMessage message) {
        super(message.getErrorMessage() + message.getMessage());
    }
}
