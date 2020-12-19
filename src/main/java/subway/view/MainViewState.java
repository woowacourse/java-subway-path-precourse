package subway.view;

import subway.SubwayPath;
import subway.exception.StateNotInitializedException;
import subway.util.MainViewUtil;
import subway.view.input.MainInputView;
import subway.view.output.CommonOutputView;
import subway.view.output.MainOutputView;

import java.util.Optional;
import java.util.Scanner;

public class MainViewState implements ViewState {
    private static MainViewState mainView;

    private MainInputView mainInputView;
    private MainOutputView mainOutputView;
    private CommonOutputView commonOutputView;

    private MainViewState(Scanner scanner) {
        mainInputView = new MainInputView(scanner);
        mainOutputView = new MainOutputView();
        commonOutputView = new CommonOutputView();
    }

    public static void initializeMainView(Scanner scanner){
        mainView = new MainViewState(scanner);
    }

    public static MainViewState getMainView(){
        if (!Optional.of(mainView).isPresent()) {
            throw new StateNotInitializedException();
        }
        return mainView;
    }

    public boolean render(SubwayPath subwayPath) {
        boolean isContinuing = true;
        try {
            mainOutputView.printMenu();
            String menuFeature = mainInputView.getMenuTargetFeature();
            checkAndRunSwitchViewToRouteLookupView(menuFeature, subwayPath);
            isContinuing = checkAndQuitApplication(menuFeature);
        } catch (IllegalArgumentException illegalArgumentException) {
            commonOutputView.printExceptionMessage(illegalArgumentException);
        }
        return isContinuing;
    }

    private void checkAndRunSwitchViewToRouteLookupView(String menuFeature, SubwayPath subwayPath) {
        if (!menuFeature.equals(MainViewUtil.getBtnSelectPath())) {
            return;
        }
        changeStateToRouteLookupView(subwayPath);
    }

    private boolean checkAndQuitApplication(String menuFeature) {
        if (!menuFeature.equals(MainViewUtil.getBtnExit())) {
            return true;
        }
        return false;
    }

    private void changeStateToRouteLookupView(SubwayPath subwayPath){
        subwayPath.setViewState(RouteLookupViewState.getRouteLookupView());
    }
}
