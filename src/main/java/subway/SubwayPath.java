package subway;

import subway.view.InputView;
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
        String order = selectMenu();
    }

    private String selectMenu(){
        try {
            OutputView.printAskingFunction();
            return InputView.getMainMenu(scanner);
        } catch (IllegalArgumentException e){
            OutputView.printError(e.getMessage());
            return selectMenu();
        }
    }

}
