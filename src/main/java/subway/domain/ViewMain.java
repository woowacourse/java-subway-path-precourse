package subway.domain;

import java.util.Scanner;

public class ViewMain {

    private static final String MAIN_SCREEN = "## 메인 화면";
    private static final String FIND_PATH = "1. 경로 조회";
    private static final String QUIT = "Q. 종료";
    private static final String SELECT_FUNCTION = "## 원하는 기능을 선택하세요";
    private static final String FUNCTION_QUIT = "Q";
    private static final String FUNCTION_PATH = "1";

    private boolean quit = false;

    Input input = new Input();
    ViewPath viewPath = new ViewPath();

    public void printFirstScreen() {
        System.out.println(MAIN_SCREEN);
        System.out.println(FIND_PATH);
        System.out.println(QUIT);
        System.out.println();

    }

    public String printFunctionScreen(Scanner scanner) {
        System.out.println(SELECT_FUNCTION);
        String function = input.mainChoice(scanner);
        System.out.println();
        return function;
    }

    private void printPath(Scanner scanner, String function) {
        if (function.equals(FUNCTION_PATH)) {
            viewPath.printPathProgram(scanner);
        }
    }


    private void quitProgram(String function) {
        if (function.equals(FUNCTION_QUIT)) {
            this.quit = true;
        }
    }

    public void run(Scanner scanner) {
        this.quit = false;
        while (!quit) {
            try {
                printFirstScreen();
                String function = printFunctionScreen(scanner);
                printPath(scanner, function);
                quitProgram(function);
            } catch (IllegalArgumentException illegalArgumentException) {

            }
        }

    }
}
