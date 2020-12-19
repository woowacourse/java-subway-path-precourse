package subway;

import subway.view.screen.ScreenManager;
import subway.view.screen.action.path.ShortestDistancePathActionScreen;
import subway.view.screen.action.path.ShortestTimePathActionScreen;

public class HandlerMapping {

    public static void mapping(CategoryType categoryType, ActionType actionType) {
        if (categoryType == CategoryType.STATION) {
            pathMapping(categoryType, actionType);
        }
    }

    private static void pathMapping(CategoryType categoryType, ActionType actionType) {
        if (actionType == ActionType.SHORTEST_DISTANCE_PATH) {
            ScreenManager.push(new ShortestDistancePathActionScreen(categoryType));
            return;
        }

        if (actionType == ActionType.SHORTEST_TIME_PATH) {
            ScreenManager.push(new ShortestTimePathActionScreen(categoryType));
        }
    }
}
