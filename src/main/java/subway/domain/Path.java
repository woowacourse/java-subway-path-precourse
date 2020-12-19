package subway.domain;

import java.util.HashMap;
import view.OutputView;

public class Path {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String ERROR_SAME_FROM_TO = ERROR_PREFIX + "도착지와 목적지가 같습니다.";
    private static final String ERROR_NOT_EXIST_STATION = ERROR_PREFIX + "도착지 혹은 목적지가 존재하지 않습니다.";
    private static final String ERROR_NOT_CONNECTED = ERROR_PREFIX + "도착지에서 목적지까지의 경로가 존재하지 않습니다.";

    private Station from;
    private Station to;
    private boolean isExistPath = false;

    public Path(Station from, Station to) {
        this.from = from;
        this.to = to;
    }

    public boolean validatePath() {
        if (!isExistStation()) {
            OutputView.print(ERROR_NOT_EXIST_STATION);
            return false;
        }
        if (isFromEqualTo()) {
            OutputView.print(ERROR_SAME_FROM_TO);
            return false;
        }
        if (!isConnected()) {
            OutputView.print(ERROR_NOT_CONNECTED);
            return false;
        }
        return true;
    }

    private boolean isFromEqualTo() {
        return from == to;
    }

    private boolean isExistStation() {
        return from != null && to != null;
    }

    private boolean isConnected() {
        dfs(new HashMap<>(), from, to);
        return isExistPath;
    }

    private void dfs(HashMap<String, Boolean> visited, Station now, Station to) {
        if (now == to) {
            isExistPath = true;
            return;
        }

        visited.put(now.getName(), true);

        for (Edge edge : now.edges()) {
            if (!visited.containsKey(edge.getDestination().getName())) {
                dfs(visited, edge.getDestination(), to);
            }
        }
    }
}
