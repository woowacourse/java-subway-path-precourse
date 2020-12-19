package subway.controller;

import subway.view.SubwayView;

import java.util.Scanner;

public class SubwayController {
    private SubwayView subwayView;

    public SubwayController(Scanner scanner) {
        subwayView = new SubwayView(scanner);
    }

    public void run() {
    }
}
