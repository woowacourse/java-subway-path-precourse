package subway.view.screen;

import subway.MainType;
import subway.StatusType;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;

public class MainScreen {
    private static final String MAIN_SCREEN = "메인 화면";
    private static final String INPUT_COMMAND = "원하는 기능을 입력하세요.";


    public void show() {
        OutputView.printlnGuide(MAIN_SCREEN);
        Arrays.stream(MainType.values())
                .forEach(mainType -> {
                    OutputView.printTypeList(mainType.getCommand(), mainType.getTypeName());
                });
    }

    public void logic(InputView inputView) {
        OutputView.printlnGuide(INPUT_COMMAND);
        String command = inputView.scanMainTypeCommand();
        if (command.equals(MainType.FIND_PATH.getCommand())) {
            FindPathScreen findPathScreen = new FindPathScreen();
            findPathScreen.show();
            findPathScreen.logic(inputView);
        }
        if (command.equals(MainType.EXIT)) {
            StatusType.finishSubwayPath();
        }
    }
}
