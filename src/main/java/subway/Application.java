package subway;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        OutputView.println("## 메인 화면");
        OutputView.println("1. 경로 조회");
        OutputView.println("Q. 종료");
        InputView.nextLine(scanner);
    }
}
