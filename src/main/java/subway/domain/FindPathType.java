package subway.domain;

import subway.exception.SubwayException;

import java.util.Arrays;
import java.util.Objects;

public enum FindPathType {
    TIME("1", "최단 거리"),
    DISTANCE("2", "최소 시간");

    private static final String ERR_WRONG_INPUT_COMMAND_MSG = "잘 못된 명령어 입력입니다.";

    FindPathType(String command, String title) {
        this.command = command;
        this.title = title;
    }

    String command;
    String title;

    public static FindPathType findByCommand(String command){
        return Arrays.stream(FindPathType.values())
                .filter(findPathType -> Objects.equals(findPathType.command,command))
                .findAny()
                .orElseThrow(() -> new SubwayException(ERR_WRONG_INPUT_COMMAND_MSG));
    }
}
