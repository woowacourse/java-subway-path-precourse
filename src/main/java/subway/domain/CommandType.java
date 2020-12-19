package subway.domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public enum CommandType {
    SEARCH("1", "경로 조회"), EXIT("Q", "종료");

    private static final String NOT_FOUND_ERROR_MESSAGE = "올바르지 않은 명령입니다.";
    private static final String PERIOD = ".";
    private static final String SPACE = " ";
    private static final String ENTER = "\n";

    private final String selector;
    private final String content;

    CommandType(String selector, String content) {
        this.selector = selector;
        this.content = content;
    }

    public static String getInfos() {
        return Arrays.stream(values())
                .map(command -> command.selector + PERIOD +SPACE + command.content + ENTER)
                .collect(Collectors.joining());
    }

    public static CommandType of(String userMessage) {
        return Arrays.stream(values())
                .filter(command -> Objects.equals(command.selector, userMessage))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_ERROR_MESSAGE));
    }

    public boolean isSearch() {
        return equals(SEARCH);
    }

    public boolean isExit() {
        return equals(EXIT);
    }
}
