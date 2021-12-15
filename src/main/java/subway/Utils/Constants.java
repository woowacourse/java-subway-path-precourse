package subway.Utils;

public class Constants {
	public static final String[] STATIONS = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
	public static final String[] LINES = {"2호선", "3호선", "신분당선"};

	public static final Object[][] DISTANCES = new Object[][] {
		{"교대역", "강남역", 2},
		{"강남역", "역삼역", 2},
		{"교대역", "남부터미널역", 3},
		{"남부터미널역", "양재역", 6},
		{"양재역", "매봉역", 1},
		{"강남역", "양재역", 2},
		{"양재역", "양재시민의숲역", 10}

	};
	public static final Object[][] TIMES = new Object[][] {
		{"교대역", "강남역", 3},
		{"강남역", "역삼역", 3},
		{"교대역", "남부터미널역", 2},
		{"남부터미널역", "양재역", 5},
		{"양재역", "매봉역", 1},
		{"강남역", "양재역", 8},
		{"양재역", "양재시민의숲역", 3}

	};

	public static final String ERROR = "\n[ERROR] ";
	public static final String ERROR_SAME_NAME = ERROR + "출발역과 도착역이 동일합니다.";
	public static final String ERROR_WRONG_MAIN_INPUT = ERROR + "1 혹은 Q를 입력하시오.\n";
	public static final String ERROR_WRONG_STANDARD_INPUT = ERROR + "1,2 혹은 B를 입력하시오.";

	public static final String MAIN_INPUT_START = "1";
	public static final String MAIN_INPUT_QUIT = "Q";

	public static final String MAIN_STANDARD_DISTANCE = "1";
	public static final String MAIN_STANDARD_TIME = "2";
	public static final String MAIN_STANDARD_QUIT = "B";

}
