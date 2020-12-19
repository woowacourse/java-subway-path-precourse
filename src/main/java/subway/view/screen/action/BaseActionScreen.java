package subway.view.screen.action;

import subway.CategoryType;
import subway.view.InputView;
import subway.view.screen.Screen;
import subway.view.screen.ScreenManager;

public abstract class BaseActionScreen implements Screen {

    public static final String TOTAL_DISTANCE_MESSAGE = "총 거리";
    public static final String TOTAL_TIME_MESSAGE = "총 소요 시간";
    public static final String MINUTE_MESSAGE = "분";
    public static final String KILLOMETER_MESSAGE = "km";

    public CategoryType selectedCategoryType;

    public BaseActionScreen(CategoryType selectedCategoryType) {
        this.selectedCategoryType = selectedCategoryType;
    }

    @Override
    public void logic(InputView inputView) {
        action(inputView);
        ScreenManager.goToFirstScreen();
    }

    protected abstract void action(InputView inputView);
}
