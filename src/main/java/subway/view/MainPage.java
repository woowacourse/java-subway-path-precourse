package subway.view;

import utils.ErrorUtils;

public class MainPage {
    public void printMainPage(){
        System.out.println("## 메인 화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료");
        System.out.println("\n## 원하는 기능을 선택하세요.");
    }

    public void printWrongItemError(){
        ErrorUtils.printError("잘못된 입력입니다.");
    }
}
