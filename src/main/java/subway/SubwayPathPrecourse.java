package subway;

import subway.util.Machine;
import subway.view.InputView;
import subway.view.screen.MainScreen;
import subway.view.screen.ScreenManager;

public class SubwayPathPrecourse {

    public static void start(InputView inputView){
        TempData.load();
        ScreenManager.push(new MainScreen());
        while(!ScreenManager.isEmpty()){
            Machine.screenRun(()->{
                ScreenManager.show();
                ScreenManager.menuSelect(inputView);
            });
        }
    }
}
