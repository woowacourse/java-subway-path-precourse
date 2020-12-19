package subway.view;

import subway.domain.MainAction;
import subway.domain.PathAction;

public class OutputView {

    public static final String NOTICE_HEAD = "## ";

    public static void printMain() {
        System.out.println();
        System.out.println(NOTICE_HEAD +"메인 화면");
        for(MainAction mainAction: MainAction.values()){
            System.out.println(mainAction.getActionNumber() +". "+ mainAction.getActionName());
        }
    }

    public static void printPathAction() {
        System.out.println();
        System.out.println(NOTICE_HEAD +"경로 기준");
        for(PathAction pathAction: PathAction.values()){
            System.out.println(pathAction.getActionNumber() +". "+ pathAction.getActionName());
        }
    }
}
