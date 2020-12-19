package subway.view.screen;

import java.util.Arrays;
import java.util.List;
import subway.CategoryType;
import subway.utils.ErrorUtils;
import subway.view.InputView;
import subway.view.OutputView;

public class MainScreen implements Screen {

    public static final String MAIN_SCREEN_MESSAGE = "메인 화면";

    public static final List<CategoryType> MAIN_CATEGORIES = Arrays.asList(
        CategoryType.STATION
    );

    @Override
    public void visualize() {
        OutputView.printTitle(MAIN_SCREEN_MESSAGE);

        for (int i = 1; i <= MAIN_CATEGORIES.size(); i++) {
            System.out.println(i + COMMA + MAIN_CATEGORIES.get(i - 1).getName());
        }

        OutputView.println(InputView.EXIT_COMMAND.toUpperCase() + COMMA + CategoryType.EXIT.getName());
    }

    @Override
    public void logic(InputView inputView) {
        int categoryCommandNumber = getCategoryCommandNumber(inputView);
        if (categoryCommandNumber == InputView.EXIT) {
            ScreenManager.exit();
            return;
        }

        CategoryType selectedCategoryType = MAIN_CATEGORIES.get(categoryCommandNumber - 1);
        ScreenManager.push(new ManagementScreen(selectedCategoryType));
    }

    private int getCategoryCommandNumber(InputView inputView) {
        return (int) ErrorUtils.repeatingUntilNoException(() -> {
            OutputView.printTitle(Screen.SELECT_CATEGORY_MESSAGE);
            return inputView.readCategoryCommandNumber();
        });
    }
}
