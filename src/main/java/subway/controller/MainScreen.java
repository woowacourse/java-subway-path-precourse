package subway.controller;

import java.util.List;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;

public class MainScreen implements Screen {
    private static final MainScreen mainScreen = new MainScreen();
    
    private static final String MAIN_SCREEN_TITLE = "메인 화면";
    private static final String SHOW_ROUTE_MESSAGE = "경로 조회";
    private static final String EXIT_MESSAGE = "종료하기";
    
    private final List<Choice> choices = new ArrayList<>();
    
    private MainScreen() {
        choices.add(new Choice(Choice.COMMAND_ONE, SHOW_ROUTE_MESSAGE,
                () -> Controller.addScreen(RouteScreen.getInstance())));
        choices.add(new Choice(Choice.COMMAND_QUIT, EXIT_MESSAGE, () -> Controller.popScreen()));
    }
    
    public static Screen getInstance() {
        return mainScreen;
    }

    @Override
    public void run() {
        OutputView.printMenu(MAIN_SCREEN_TITLE, choices);
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
}
