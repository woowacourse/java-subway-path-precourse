package subway.View;

import java.util.Scanner;

public class InputView {
	public static String inputMain(Scanner scanner) {
		System.out.println("## 메인 화면");
		System.out.println("1. 경로 조회");
		System.out.println("Q. 종료\n");
		System.out.println("## 원하는 기능을 선택하세요.");
		return scanner.nextLine();
	}

	public static String inputStandard(Scanner scanner) {
		System.out.println("\n## 경로 기준");
		System.out.println("1. 최단 거리");
		System.out.println("2. 최소 시간");
		System.out.println("B. 돌아가기");

		System.out.println("\n## 원하는 기능을 선택하세요.");
		return scanner.nextLine();
	}

	public static String inputStartStation(Scanner scanner) {
		System.out.println("\n## 출발역을 입력하세요.");
		return scanner.nextLine();
	}

	public static String inputFinishStation(Scanner scanner) {
		System.out.println("\n## 도착역을 입력하세요.");
		return scanner.nextLine();
	}
}
