package subway.domain;

import subway.exception.SubwayException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public enum FindPathType {
    TIME("1", "최단 거리"),
    DISTANCE("2", "최소 시간");

    private static final String ERR_WRONG_INPUT_COMMAND_MSG = "해당 메뉴는 없습니다.";

    FindPathType(String command, String title) {
        this.command = command;
        this.title = title;
    }

    private String command;
    private String title;

    public static FindPathType findByCommand(String command) {
        return Arrays.stream(FindPathType.values())
                .filter(findPathType -> Objects.equals(findPathType.command, command))
                .findAny()
                .orElseThrow(() -> new SubwayException(ERR_WRONG_INPUT_COMMAND_MSG));
    }

    public static List<String> getTitles() {
        return Arrays.stream(FindPathType.values())
                .map(finePathType -> finePathType.title)
                .collect(Collectors.toList());
    }

    public static List<String> getCommands() {
        return Arrays.stream(FindPathType.values())
                .map(finePathType -> finePathType.command)
                .collect(Collectors.toList());
    }
}
