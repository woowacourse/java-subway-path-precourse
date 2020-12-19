package view;

public class OutputView {
	
	private static final String MAIN_MESSAGE = "## 메인 화면";
	private static final String ROUTE_LOOK_UP_MESSAGE = "1. 경로 조회";
	
	private static final String ROUTE_STANDARD_MESSAGE = "## 경로 기준";
	private static final String ROUTE_SHORTEST_DISTANCE = "1. 최단 거리";
	private static final String ROUTE_SHORTEST_TIME = "2. 최소 시간";
	
	private static final String DEPARTURE_STATION = "## 출발역을 입력하세요.";
	private static final String ARRIVAL_STATION = "## 도착역을 입력하세요.";
	private static final String SElECT_FUNCTION = "## 원하는 기능을 선택하세요.";
	
	private static final String INFOMATION_MESSAGE = "[INFO] ";
	private static final String ERROR_MESSAGE = "[ERROR] ";
	private static final String SYSTEM_OUT_MESSAGE = "Q. 종료";
	private static final String BACK_TO_MAIN = "B. 돌아가기";
	
	private static final String LOOK_UP_RESULT = "## 조회 결과";
	private static final String TOTAL_DISTANCE = "총 거리:";
	private static final String TOTAL_TIME = "총 소요 시간:";
	
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

}
