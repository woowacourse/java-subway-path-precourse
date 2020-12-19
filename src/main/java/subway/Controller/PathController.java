package subway.Controller;

import subway.View.InputView;
import subway.View.OutputView;

import java.util.Scanner;

public class PathController {
    OutputView outputView=new OutputView();
    InputView inputView =new InputView();
    private static final String PATH_CONTROLLER_SHORT_DISTANCE="1";
    private static final String PATH_CONTROLLER_SHORT_TIME="2";
    private static final String PATH_CONTROLLER_BACK="B";

    public void startPathMenu(Scanner scanner){
        outputView.setPathMenuPathStandard();
        String tmpSavePathMenuChoice=inputView.getChooseFunction(scanner);
        if(tmpSavePathMenuChoice.equals(PATH_CONTROLLER_BACK)) {
            return;
        }
        if(tmpSavePathMenuChoice.equals(PATH_CONTROLLER_SHORT_DISTANCE)) {
            return;
        }
        if(tmpSavePathMenuChoice.equals(PATH_CONTROLLER_SHORT_TIME)) {
            return;
        }
        startPathMenu(scanner);
    }
    public void setPathControllerShortDistance(){

    }
    public void setPathControllerShortTime(){

    }

}
