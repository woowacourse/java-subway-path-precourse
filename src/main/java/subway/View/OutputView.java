package subway.View;

public class OutputView {
    private static final String MAIN_MENU_MAIN_DISPLAY="## 메인화면";
    private static final String MAIN_MENU_PATH_SEARCH="1. 경로 조회";
    private static final String MAIN_MENU_QUIT="Q. 종료";

    private static final String PATH_MENU_PATH_STANDARD="## 경로 기준";
    private static final String PATH_MENU_SHORT_DISTANCE="1. 최단거리";
    private static final String PATH_MENU_SHORT_TIME="2. 최소 시간";
    private static final String PATH_MENU_BACK="B. 돌아가기";

    public void setMainMenuMainDisplay(){
        System.out.println(MAIN_MENU_MAIN_DISPLAY);
        System.out.println(MAIN_MENU_PATH_SEARCH);
        System.out.println(MAIN_MENU_QUIT);
    }
    public void setPathMenuPathStandard(){
        System.out.println();
        System.out.println(PATH_MENU_PATH_STANDARD);
        System.out.println(PATH_MENU_SHORT_DISTANCE);
        System.out.println(PATH_MENU_SHORT_TIME);
        System.out.println(PATH_MENU_BACK);
    }
}
