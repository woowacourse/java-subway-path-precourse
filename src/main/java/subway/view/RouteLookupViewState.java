package subway.view;

import subway.SubwayPath;
import subway.exception.StateNotInitializedException;
import subway.util.MainViewUtil;
import subway.util.RouteLookupViewUtil;
import subway.view.input.RouteLookupInputView;
import subway.view.output.CommonOutputView;
import subway.view.output.RouteLookupOutputView;

import java.util.Optional;
import java.util.Scanner;

public class RouteLookupViewState implements ViewState {
    private static RouteLookupViewState routeLookupView;

    private RouteLookupInputView routeLookupInputView;
    private RouteLookupOutputView routeLookupOutputView;
    private CommonOutputView commonOutputView;

    private RouteLookupViewState(Scanner scanner) {
        routeLookupInputView = new RouteLookupInputView(scanner);
        routeLookupOutputView = new RouteLookupOutputView();
        commonOutputView = new CommonOutputView();
    }

    public static void initializeRouteLookupView(Scanner scanner){
        routeLookupView = new RouteLookupViewState(scanner);
    }

    public static RouteLookupViewState getRouteLookupView(){
        if (!Optional.of(routeLookupView).isPresent()) {
            throw new StateNotInitializedException();
        }
        return routeLookupView;
    }

    public boolean render(SubwayPath subwayPath) {
        try {
            routeLookupOutputView.printMenu();
            String menuFeature = routeLookupInputView.getMenuTargetFeature();
            checkAndGoBackToMainView(menuFeature, subwayPath);
        } catch (IllegalArgumentException illegalArgumentException) {
            commonOutputView.printExceptionMessage(illegalArgumentException);
        }
        return true;
    }

    private void checkAndGoBackToMainView(String menuFeature, SubwayPath subwayPath) {
        if (!menuFeature.equals(RouteLookupViewUtil.getBtnBack())) {
            return;
        }
        changeStateToMainView(subwayPath);
    }

    private void changeStateToMainView(SubwayPath subwayPath){
        subwayPath.setViewState(MainViewState.getMainView());
    }
}
