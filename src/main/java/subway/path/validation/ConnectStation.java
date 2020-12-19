package subway.path.validation;

import org.jgrapht.GraphPath;

public class ConnectStation {
    private static final String NOT_CONNECT = "[ERROR] 시작역과 도착역이 연결되어 있지 않은 역입니다.";

    public static void validate(GraphPath path) {
        if (path == null) {
            throw new IllegalArgumentException(NOT_CONNECT);
        }
    }
}
