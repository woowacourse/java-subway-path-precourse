package subway;

import subway.domain.*;
import subway.validator.Validator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현

        LineRepository.lineInitialization();
        selectUtils(scanner);
    }

    public static void selectUtils(Scanner scanner) {
        final int MAIN_QUIT = 0;

        while (true) {
            String chosen;
            int chosenNumber;
            Route route = new Route(scanner);

            System.out.println("## 메인 화면\n1. 경로 조회\nQ. 종료\n\n## 원하는 기능을 선택하세요.");
            chosen = scanner.next();
            chosenNumber = Validator.isMainInputRight(chosen);
            if (chosenNumber == MAIN_QUIT) {
                break;
            }
            route.play();
        }
    }
}
