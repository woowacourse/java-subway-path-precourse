package subway.view.screen;

import subway.util.Machine;
import subway.view.InputView;
import subway.view.MenuType;
import subway.view.OutputView;

import java.util.Arrays;

public class MainScreen implements Screen{

    private static final String TITLE="## 메인 화면";
    private static final String SELECT_TYPE="## 원하는 기능을 선택하세요.";
    private static final String COMA=". ";
    private static final String ERROR_MESSAGE="잘못된 입력입니다.";

    @Override
    public void show() {
        OutputView.println(TITLE);
        Arrays.stream(MenuType.values()).forEach(menuType -> {
            OutputView.println(menuType.getKey()+COMA+menuType.getName());
        });
        OutputView.println();
    }

    @Override
    public void menuSelect(InputView inputView) {
        String menuType=getMenuInput(inputView);
        if(menuType.equals(MenuType.QUIT.getKey())){
            ScreenManager.clear();
            return;
        }

        ScreenManager.push(new PathOptionSelectScreen());
        OutputView.println();
    }

    private String getMenuInput(InputView inputView){
        OutputView.println(SELECT_TYPE);
        while(true){
            String input=inputView.inputRequest();
            if(MenuType.isValidInput(input)){
                return input;
            }
            OutputView.printError(ERROR_MESSAGE);
        }
    }
}
