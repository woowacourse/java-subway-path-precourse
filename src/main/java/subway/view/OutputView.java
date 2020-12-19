package subway.view;

import subway.domain.MainAction;

public class OutputView {

    public static void printMain() {
        System.out.println();
        System.out.println("## "+"메인 화면");
        for(MainAction mainAction: MainAction.values()){
            System.out.println(mainAction.getActionNumber() +". "+ mainAction.getActionName());
        }
    }
}
