package subway.screen;

public interface Screen {
    public static final String SHARP = "## ";
    public static final String QUIT = "Q. 종료";
    public static final String BACK = "B. 돌아가기";
    public static final String DOT = ". ";

    public void printScreen();
}
