package subway.view;

import subway.domain.Line;
import subway.domain.LineRepository;

public class OutputView {

	private static final String MAIN_MESSAGE = "## ���� ȭ��";
	private static final String ROUTE_LOOK_UP_MESSAGE = "1. ��� ��ȸ";

	private static final String ROUTE_STANDARD_MESSAGE = "## ��� ����";
	private static final String ROUTE_SHORTEST_DISTANCE = "1. �ִ� �Ÿ�";
	private static final String ROUTE_SHORTEST_TIME = "2. �ּ� �ð�";

	public static final String DEPARTURE_STATION = "## ��߿��� �Է��ϼ���.";
	public static final String ARRIVAL_STATION = "## �������� �Է��ϼ���.";
	public static final String SElECT_FUNCTION = "\n## ���ϴ� ����� �����ϼ���.";

	private static final String INFOMATION_MESSAGE = "[INFO] ";
	private static final String ERROR_MESSAGE = "[ERROR] ";
	private static final String DIVIDE_MESSAGE = "---";
	private static final String SYSTEM_OUT_MESSAGE = "Q. ����";
	private static final String BACK_TO_MAIN = "B. ���ư���";

	private static final String LOOK_UP_RESULT = "## ��ȸ ���";
	private static final String TOTAL_DISTANCE = "�� �Ÿ�:";
	private static final String TOTAL_TIME = "�� �ҿ� �ð�:";

	public static void printMainScreen() {
		System.out.println(MAIN_MESSAGE);
		System.out.println(ROUTE_LOOK_UP_MESSAGE);
		System.out.println(SYSTEM_OUT_MESSAGE);
	}

	public static void printRoutestandard() {
		System.out.println(ROUTE_STANDARD_MESSAGE);
		System.out.println(ROUTE_SHORTEST_DISTANCE);
		System.out.println(ROUTE_SHORTEST_TIME);
		System.out.println(BACK_TO_MAIN);
	}

	public static void printMap() {
		System.out.println(LOOK_UP_RESULT);
		addInfoMessage(DIVIDE_MESSAGE);
		for (Line line : LineRepository.lines()) {
			addInfoMessage(DIVIDE_MESSAGE);
			addInfoMessage(line.getName());
			addInfoMessage(DIVIDE_MESSAGE);
			addInfoLine(line);
		}
	}

	private static void addInfoMessage(String message) {
		System.out.println(INFOMATION_MESSAGE + message);
	}

	private static void addInfoLine(Line line) {
		for (String stationName : line.getSection()) {
			addInfoMessage(stationName);
		}
	}

}
