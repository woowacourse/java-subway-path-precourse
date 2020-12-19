package subway.screen;

public class MainScreen implements Screen{
    private static final String MAIN_SCREEN_INFO = "메인 화면";
    private static final String[] MAIN_INFO = {"경로 조회"};

    @Override
    public void printScreen() {
        System.out.println(SHARP + MAIN_SCREEN_INFO);
        for (int i = 0; i < MAIN_INFO.length; i++) {
            System.out.println((i + 1) + DOT + MAIN_INFO[i]);
        }
        System.out.println(QUIT);
        System.out.println();
    }
}
