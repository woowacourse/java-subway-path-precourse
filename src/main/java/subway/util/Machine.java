package subway.util;

import subway.view.OutputView;
import subway.view.screen.ScreenManager;

public class Machine {

    public static void screenRun(SubwayMachine subwayMachine){
        try{
            subwayMachine.execute();
        }catch (RuntimeException e){
            OutputView.printError(e.getMessage());
            ScreenManager.back();
        }
    }
}
