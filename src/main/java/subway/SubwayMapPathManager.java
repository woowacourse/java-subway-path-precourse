package subway;

import subway.controller.PathController;
import subway.type.FunctionType;
import subway.type.ManagementType;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayMapPathManager {

    private final InputView inputView;
    private final PathController pathController;

    public SubwayMapPathManager(InputView inputView, PathController pathController) {
        this.inputView = inputView;
        this.pathController = pathController;
    }

    public void run() {
        ManagementType managementType = ManagementType.initiate();
        while (managementType.isRunning()) {
            OutputView.printMainDisplay();
            managementType = inputView.inputManagementType();
            executeExceptionHandler(managementType);
        }
    }

    private void executeExceptionHandler(ManagementType managementType) {
        if (managementType == ManagementType.EXIT) {
            return;
        }
        try {
            visualizeRouteSearchDisplay(managementType);
        } catch (RuntimeException runtimeException) {
            OutputView.printErrorMessage(runtimeException);
            executeExceptionHandler(managementType);
        }
    }

    private void visualizeRouteSearchDisplay(ManagementType managementType) {
        OutputView.printRouteSearchDisplay();
        FunctionType functionType = inputView.inputFunctionType(managementType);
    }
}
