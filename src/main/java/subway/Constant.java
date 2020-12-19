package subway;

public class Constant {

    public static final String VIEW_HEADER = "\n## ";

    public static final String VIEW_MAIN_HEADER = "메인 화면";
    public static final String VIEW_PATH_RULE_HEADER = "경로 기준";
    public static final String VIEW_RESULT_HEADER = "조회 결과";

    public static final String VIEW_MENU_FORMAT = "%s. %s\n";

    public static final String VIEW_ASKING_FUNCTION = "원하는 기능을 선택하세요.";
    public static final String VIEW_ASKING_STARTING_STATION = "출발역을 입력하세요.";
    public static final String VIEW_ASKING_ENDING_STATION = "도착역을 입력하세요.";

    public static final String EXCEPTION_HEADER = "[ERROR]";
    public static final String EXCEPTION_FORMAT = "\n" + EXCEPTION_HEADER + " %s";
    public static final String ILLEGAL_ARGUMENT_EXCEPTION_INVALID_ORDER = "선택할 수 없는 기능입니다.\n";
    public static final String ILLEGAL_ARGUMENT_EXCEPTION_INVALID_STATION= "등록되지 않은 역입니다.\n";
    public static final String ILLEGAL_ARGUMENT_EXCEPTION_INVALID_SAME_POINT= "출발역과 도착역이 동일합니다.\n";

    public static final String RESULT_HEADER = "[INFO]";
    public static final String RESULT_DIVIDER = "---";
    public static final String RESULT_FORMAT = RESULT_HEADER + " %s\n";
}
