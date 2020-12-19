package subway.view;

import java.util.List;

import subway.domain.ShortenPathDTO;

public class OutputView {

    public void showMain() {
        System.out.printf("## 메인화면\n");
        System.out.printf("1. 경로 조회\n");
        System.out.printf("Q. 종료\n\n");
    }

    public void showDirection() {
        System.out.printf("## 경로기준\n");
        System.out.printf("1. 최단 거리\n");
        System.out.printf("2. 최소 시간\n");
        System.out.printf("B. 돌아가기\n\n");
    }

    public void showPath(ShortenPathDTO shortenPathDTO) {
        System.out.printf("## 조회 결과\n");
        System.out.printf("[INFO] ---\n");
        System.out.printf("총 거리: %dkm\n", shortenPathDTO.getTotalDistance());
        System.out.printf("총 소요 시간: %d분\n", shortenPathDTO.getTotalElapsedTime());
        System.out.printf("[INFO] ---\n");
        showPathStations(shortenPathDTO.getStationNames());
    }

    private void showPathStations(List<String> stationNames) {
        for (String stationName : stationNames) {
            System.out.printf("[INFO] %s\n", stationName);
        }

        System.out.println();
    }
}
