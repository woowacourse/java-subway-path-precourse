package subway;

import java.util.Scanner;

import subway.domain.SubwaySection;

public class MainManegement {
	private static final String MAIN_SELECT_MESSAGE = "## 메인 화면\n" + "1. 경로 조회\r\n" + "Q. 종료\n\n" + "## 원하는 기능을 선택하세요.";
	private static final String ERROR_INPUT_MESSAGE = "[ERROR] 잘못된 입력값 입니다.\n";
	private static final String END_PROGRAM_MESSAGE = "##프로그램을 종료합니다.";

	public MainManegement(Scanner scanner, SubwaySection subwaySection) {
		boolean end = false;
		while (!end) {
			System.out.println(MAIN_SELECT_MESSAGE);
			end = selectMain(scanner, subwaySection);
		}
	}

	public static Boolean selectMain(Scanner scanner, SubwaySection subwaySection) {
		String select = scanner.nextLine();
		if (select.equals("1")) {
			SectionSearch.sectionSearchMenu(scanner, subwaySection);
			return false;
		}
		if (select.equals("Q") || select.equals("q")) {
			System.out.println(END_PROGRAM_MESSAGE);
			return true;
		}
		System.out.println(ERROR_INPUT_MESSAGE);
		return false;
	}
}
