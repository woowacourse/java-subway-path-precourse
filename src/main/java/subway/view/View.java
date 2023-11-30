package subway.view;

import java.util.Scanner;
import subway.view.io.Printer;
import subway.view.io.Reader;

public class View {

    //todo 각 입력에 대해 실행할 메서드를 enum이 가지게 하면?
    private final Reader reader;
    private final Printer printer = new Printer();

    public View(Scanner scanner) {
        reader = new Reader(scanner);
    }

    public String mainMenuView() {
        printer.printMessage("## 메인 화면");
        printer.printMessage("1. 경로 조회");
        printer.printMessage("Q. 종료");
        printer.printMessage("");
        printInputMenu();

        return reader.getString();
    }

    private void printInputMenu(){
        printer.printMessage("## 원하는 기능을 선택하세요.");

    }

    public void printInfo(String infoMessage) {
        //todo 상수 추출
        printer.printMessage("[INFO] " + infoMessage);
    }

    public void printException(String exceptionMessage) {
        //todo 상수 추출
        printer.printMessage("[ERROR] " + exceptionMessage);
    }
}
