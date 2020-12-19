package subway;

import java.util.Scanner;

import subway.controller.MainManagement;
import subway.dummyData.DummyData;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        DummyData dummy = new DummyData();
        dummy.init();
        MainManagement.execute();
    }
}
