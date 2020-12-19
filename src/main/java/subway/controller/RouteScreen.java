package subway.controller;

import java.util.ArrayList;
import java.util.List;

import subway.view.InputView;
import subway.view.OutputView;

public class RouteScreen implements Screen {
    private static final RouteScreen routeScreen = new RouteScreen();
    
    private static final String ROUTE_SCREEN_TITLE = "경로 기준";
    private static final String MINIMUM_DISTANCE_MESSAGE = "최단 거리";
    private static final String MINIMUM_TIME_MESSAGE = "최소 시간";
    private static final String BACK_MESSAGE = "돌아가기";
    
    private final List<Choice> choices = new ArrayList<>();
    
    private RouteScreen() {
        choices.add(new Choice(Choice.COMMAND_ONE, MINIMUM_DISTANCE_MESSAGE, () -> showMinimumDistanceRoute()));
        choices.add(new Choice(Choice.COMMAND_TWO, MINIMUM_TIME_MESSAGE, () -> showMinimumTimeRoute()));
        choices.add(new Choice(Choice.COMMAND_BACK, BACK_MESSAGE, () -> Controller.popScreen()));
    }
    
    public static Screen getInstance() {
        return routeScreen;
    }

    @Override
    public void run() {
        OutputView.printMenu(ROUTE_SCREEN_TITLE, choices);
        try {
            operateUserCommand(InputView.askUserCommand());
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
        }
    }
    
    private void operateUserCommand(String command) {
        for (Choice choice : choices) {
            if (choice.commandEquals(command)) {
                choice.run();
                return;
            }
        }
        throw new IllegalArgumentException(Choice.COMMAND_NOT_SELECTABLE);
    }
    
    private void showMinimumDistanceRoute() {
        // TODO
    }
    
    private void showMinimumTimeRoute() {
        // TODO
    }
}
