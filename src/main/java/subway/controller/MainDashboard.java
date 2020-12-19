package subway.controller;

import static subway.SubwayKeyWords.*;

import java.util.TreeMap;
import subway.exceptions.ExceptionOptionUnavailable;
import subway.view.InputView;
import subway.view.OutputView;

public class MainDashboard {

    public static String title = DASHBOARD_MAIN;
    TreeMap<String, String> options;
    InputView inputView;
    boolean power;

    public MainDashboard(InputView inputView) {
        this.inputView = inputView;
        power = true;
        options = new TreeMap<>();
        options.put(OPTION_NUM_1, DASHBOARD_MAIN_OPTION_1);
        options.put(OPTION_QUIT, DASHBOARD_OPTION_Q);
        startMainDashboard(inputView);
    }

    public void startMainDashboard(InputView inputView) {
        while (power) {
            String chosenOption = makeUserChooseOption(inputView);
            startChosenOption(chosenOption);
        }
    }


    public String makeUserChooseOption(InputView inputView) {
        while (true) {
            OutputView.showOptions(title, options);
            String optionChosen = inputView.chooseOption();
            try {
                checkOptions(optionChosen);
                return optionChosen;
            } catch (ExceptionOptionUnavailable e) {
                OutputView.showErrorMessage(e);
            }
        }
    }

    public void checkOptions(String input) throws ExceptionOptionUnavailable {
        if (!options.containsKey(input)) {
            throw new ExceptionOptionUnavailable();
        }
    }

    public void startChosenOption(String option) {
        if (option.equals(OPTION_NUM_1)) {
            RouteDashboard routeDashboard = new RouteDashboard(inputView);
        }

        if (option.equals(OPTION_QUIT)) {
            power = false;
        }
    }


}
