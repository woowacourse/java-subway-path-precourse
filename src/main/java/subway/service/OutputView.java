package subway.service;

public class OutputView {
    private static final char NEW_LINE = '\n';

    public void printMainMenu() {
        System.out.println(NEW_LINE+"## 메인 화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료");
    }
}