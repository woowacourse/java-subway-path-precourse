package subway;

import java.util.Scanner;

import subway.domain.StationRepository;

public class Application {
	final static Scanner scanner = new Scanner(System.in);
	static String select = null;

	public static void main(String[] args) {
		// TODO: 프로그램 구현

		while (true) {
			if (main_select_function()) {
				break;
			}
		}
	}

	private static void print_main_menu() {
		System.out.println("\n## 메인 화면");
		System.out.println("1. 경로 조회");
		System.out.println("Q. 종료");
		System.out.println("\n## 원하는 기능을 선택하세요.");
		select = scanner.next();
	}

	private static boolean main_select_function() {
		print_main_menu();
		if (select.equals("1")) {
			lookup_path_function();
			return false;
		}
		if (select.equals("Q")) {
			return true;
		}
		System.out.println("[ERROR] 잘못된 입력입니다. 다시 시도해주세요.");
		return false;
	}

	private static void print_lookup_path() {
		System.out.println("\n## 경로 기준");
		System.out.println("1. 최단 거리");
		System.out.println("2. 최소 시간");
		System.out.println("B. 돌아가기");
		System.out.println("\n## 원하는 기능을 선택하세요.");
		select = scanner.next();
	}

	private static void lookup_path_function() {
		while (true) {
			print_lookup_path();
			if (print_from_to()) {
				break;
			}
		}
	}

	private static boolean print_from_to() {
		System.out.println("\n## 출발역을 입력하세요.");
		String from = scanner.next();
		if (!StationRepository.check_station(from)) {
			return false;
		}
		System.out.println("\n## 도착역을 입력하세요.");
		String to = scanner.next();
		if (!StationRepository.check_station(to)) {
			return false;
		}
		if (Path_function.check_isSame_from_to(from, to)) {
			System.out.println("[ERROR] 출발역과 도착역이 동일합니다.");
			return false;
		}
		return select_lookup_path_function(from, to);
	}

	private static boolean select_lookup_path_function(String from, String to) {
		System.out.println("\n## 조회 결과");
		if (select.equals("B")) {
			return true;
		}
		if (select.equals("1")) {
			Path_function.shortestPathByDistance(from, to);
			return true;
		}
		if (select.equals("2")) {
			Path_function.shortestPathByTime(from, to);
			return true;
		}
		System.out.println("[ERROR] 잘못된 시도입니다. 다시 시도해 주세요.");
		return false;
	}
}
