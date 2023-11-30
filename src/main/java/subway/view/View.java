package subway.view;

import java.util.List;
import subway.domain.PathResult;
import subway.domain.Station;
import subway.view.io.Printer;

public class View {

    //todo 각 입력에 대해 실행할 메서드를 enum이 가지게 하면?
    private final Printer printer = new Printer();

    public void printMenuView() {
        printer.printMessage("## 메인 화면");
        printer.printMessage("1. 경로 조회");
        printer.printMessage("Q. 종료");
        printer.printMessage("");
        printChooseMenu();
    }

    public void printChooseMenu(){
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

    public void printLine() {
        printer.printMessage("");
    }

    public void printPathResult(PathResult result) {
        printer.printMessage("## 조회 결과");
                printInfo("---");
                printInfo("총 거리: " + result.getDistance() + "km");
                printInfo("총 소요 시간: " + result.getTime() + "분");
                printInfo("---");
                printStations(result.getStations());
    }

    private void printStations(List<Station> stations){
        stations.forEach(station -> printInfo(station.getName()));
    }
}
