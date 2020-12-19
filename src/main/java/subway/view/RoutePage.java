package subway.view;

import utils.ErrorUtils;
import utils.InfoUtils;

import java.util.List;

public class RoutePage {
    public void printRoutePage(){
        System.out.println("## 경로 기준");
        System.out.println("1. 최단 거리");
        System.out.println("2. 최소 시간");
        System.out.println("Q. 종료");
        System.out.println("\n## 원하는 기능을 선택하세요.");
    }

    public void printDepartureStationPage(){
        System.out.println("\n## 출발역을 입력하세요.");
    }

    public void printArrivalStationPage(){
        System.out.println("\n## 도착역을 입력하세요.");
    }

    public void printSelectResult(int distance, int time, List<String> shortestPath) {
        System.out.println("\n## 조회 결과");
        printSelectEdge(distance, time);
        printShortestPath(shortestPath);
    }

    public void printSelectEdge(int distance, int time) {
        InfoUtils.printInfo("---");
        InfoUtils.printInfo("총 거리: " + distance + "km");
        InfoUtils.printInfo("총 소요 시간: " + time + "분");
        InfoUtils.printInfo("---");
    }

    public void printShortestPath(List<String> shortestPath){
        for(String one : shortestPath){
            InfoUtils.printInfo(one);
        }
        System.out.println();
    }

    public void printWrongItemError(){
        ErrorUtils.printError("잘못된 입력입니다.");
    }

    public void printNullStationError(){
        ErrorUtils.printError("존재하지 않는 역입니다.");
    }

    public void printSameStationError(){
        ErrorUtils.printError("출발역과 도착역이 동일합니다.");
    }
}
