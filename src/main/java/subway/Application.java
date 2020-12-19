package subway;

import subway.domain.LineRepository;
import subway.domain.StationManager;
import subway.domain.SubwayMap;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        InitDataList.insertData();
        StationManager.start();
    }
}
