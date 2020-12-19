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

    public int getShortestTime() {
        int shortestDistance = 0;

        HashMap<Station, Integer> distanceMap = new HashMap<>();
        for (Station station : StationRepository.stations()) {
            distanceMap.put(station, Integer.MAX_VALUE);
        }

        HashMap<Station, Boolean> visitedMap = new HashMap<>();
        for (Station station : StationRepository.stations()) {
            visitedMap.put(station, false);
        }

        distanceMap.put(from, 0);

        for (Station station : StationRepository.stations()) {
            // check되지 않았으면서,
            // 현재(i)정점으로부터 dist 값이 제일 작은 정점(j)의 번호 찾기
            int min = Integer.MAX_VALUE;
            Station cur = null;
            for (Station s2 : StationRepository.stations()) {
                if (!visitedMap.get(s2) && distanceMap.get(s2) < min) {
                    min = distanceMap.get(s2);
                    cur = s2;
                }
            }

            // 현재 정점으로부터 dist 값이 제일 작은 정점을 못 찾았으면
            if (cur == null)
                break;

            // 찾은 정점(j)으로부터 갈 수 있는 경로가 이미 알고 있는 dist보다 작다면 갱신
            // index가 가지고 있는 모든 간선을 검사
            for (Edge next : cur.edges()) {
                // check되지 않았으면서 다음 노드 까지의 거리가
                // 나까지 거리 + 나로부터 다음 노드까지 거리보다 작다면 갱신
                if (!visitedMap.get(next.getDestination()) && distanceMap
                        .get(next.getDestination()) > distanceMap.get(cur) + next.getTime()) {
                    distanceMap.put(next.getDestination(), distanceMap.get(cur) + next.getTime());
                }
            }

            // 체크 완료
            visitedMap.put(cur, true);
        }

        return distanceMap.get(to);
    }

    public int getShortestDistance() {
        int shortestDistance = 0;

        HashMap<Station, Integer> distanceMap = new HashMap<>();
        for (Station station : StationRepository.stations()) {
            distanceMap.put(station, Integer.MAX_VALUE);
        }

        HashMap<Station, Boolean> visitedMap = new HashMap<>();
        for (Station station : StationRepository.stations()) {
            visitedMap.put(station, false);
        }

        distanceMap.put(from, 0);

        for (Station station : StationRepository.stations()) {

            int min = Integer.MAX_VALUE;
            Station cur = null;
            for (Station s2 : StationRepository.stations()) {
                if (!visitedMap.get(s2) && distanceMap.get(s2) < min) {
                    min = distanceMap.get(s2);
                    cur = s2;
                }
            }


            if (cur == null)
                break;


            for (Edge next : cur.edges()) {


                if (!visitedMap.get(next.getDestination()) && distanceMap
                        .get(next.getDestination()) > distanceMap.get(cur) + next.getDistance()) {
                    distanceMap.put(next.getDestination(),
                            distanceMap.get(cur) + next.getDistance());
                }
            }

            visitedMap.put(cur, true);
        }


        return distanceMap.get(to);
    }
}
