package subway.View;

import java.util.List;
import subway.domain.Station;

public class OutputView {
	public static void printResult() {
		System.out.println("\n## 조회 결과");
		System.out.println("[INFO] ---");
	}
	public static void printPath(List<Station> path) {
		path.forEach(station -> System.out.println("[INFO] " + station.getName()));
		System.out.println();
	}

	public static void printFullDistance(int fullDistance) {
		System.out.printf("[INFO] 총 거리: %dkm\n", fullDistance);
	}

	public static void printFullTime(int fullTime) {
		System.out.printf("[INFO] 총 소요 시간: %d분\n",fullTime);
		System.out.println("[INFO] ---");
	}
}
