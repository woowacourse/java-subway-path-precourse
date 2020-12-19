package subway.domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public enum SearchType {
    DISTANCE("1", "최단 거리"), TIME("2", "최소 시간"), BACK("B", "돌아가기");

    private static final String NOT_FOUND_ERROR_MESSAGE = "올바르지 않은 명령입니다.";
    private static final String PERIOD = ".";
    private static final String SPACE = " ";
    private static final String ENTER = "\n";

    private final String selector;
    private final String content;

    SearchType(String selector, String content) {
        this.selector = selector;
        this.content = content;
    }

    public static String getInfos() {
        return Arrays.stream(values())
                .map(command -> command.selector + PERIOD +SPACE + command.content + ENTER)
                .collect(Collectors.joining());
    }

    public static SearchType of(String userMessage) {
        return Arrays.stream(values())
                .filter(command -> Objects.equals(command.selector, userMessage))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_ERROR_MESSAGE));
    }

    public boolean isDistance() {
        return equals(DISTANCE);
    }

    public boolean isTime() {
        return equals(TIME);
    }

    public boolean isBack() {
        return equals(BACK);
    }
}
