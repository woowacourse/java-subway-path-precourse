package subway.view;

import static subway.common.Logger.guidePrint;
import static subway.common.Logger.infoPrint;

import java.util.List;

public class OutputView {

	public static void printMain() {
		System.out.println();
		guidePrint("메인 화면");
		System.out.println("1. 경로 조회");
		System.out.println("Q. 종료");
		System.out.println();
	}

	public static void printPathTypes() {
		System.out.println();
		guidePrint("경로 기준");
		System.out.println("1. 최단 거리");
		System.out.println("2. 최소 시간");
		System.out.println("B. 돌아가기");
		System.out.println();
	}

	public static void printLookUpResult(int totalDistance, int totalTime,
		List<String> totalRoute) {
		guidePrint("조회 결과");
		infoPrint("---");
		infoPrint("총 거리: " + totalDistance + "km");
		infoPrint("총 소요 시간: " + totalTime + "분");
		infoPrint("---");
		for (String stationName : totalRoute) {
			infoPrint(stationName);
		}
	}
}
