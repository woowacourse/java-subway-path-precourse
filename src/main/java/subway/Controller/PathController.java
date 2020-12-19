package subway.Controller;

import subway.View.InputView;
import subway.View.OutputView;

import java.util.Scanner;

public class PathController {
    private static final String PATH_CONTROLLER_SHORT_DISTANCE="1";
    private static final String PATH_CONTROLLER_SHORT_TIME="2";
    private static final String PATH_CONTROLLER_BACK="B";

    OutputView outputView=new OutputView();
    InputView inputView =new InputView();
    ComputeShortValue computeShortValue =new ComputeShortValue();

    public void startPathMenu(Scanner scanner) {
            outputView.setPathMenuPathStandard();
            String tmpSavePathMenuChoice = inputView.getChooseFunction(scanner);
            pathMenuChoice(scanner,tmpSavePathMenuChoice);
    }
    public void pathMenuChoice(Scanner scanner,String tmpSavePathMenuChoice) {
        if(tmpSavePathMenuChoice.equals(PATH_CONTROLLER_BACK)) {
            return ;
        }
        if(tmpSavePathMenuChoice.equals(PATH_CONTROLLER_SHORT_TIME)) {
            setPathControllerShortTime(scanner);
        }
        if(tmpSavePathMenuChoice.equals(PATH_CONTROLLER_SHORT_DISTANCE)) {
            setPathControllerShortDistance(scanner);
        }
    }
    public void setPathControllerShortDistance(Scanner scanner) {
        computeShortValue.setDistanceGraph(inputView.getStationStart(scanner),inputView.getStationEnd(scanner));
    }
    public void setPathControllerShortTime(Scanner scanner) {
        computeShortValue.setTimeGraph(inputView.getStationEnd(scanner),inputView.getStationStart(scanner));
    }

}
