package subway;

import subway.view.OutputView;

import java.util.Scanner;

public class SubwayPath {

    private Scanner scanner;

    public SubwayPath(Scanner scanner) {
        this.scanner = scanner;

        run();
    }

    private void run(){
        OutputView.printMainView();
    }

}
