package subway;

import subway.domain.Station;
import subway.view.InputView;
import subway.vo.FunctionType;
import subway.vo.ManagementType;

import java.util.*;

public class ApplicationContext {

    private ShortestDistance shortestDistance;
    private MinimumTime minimumTime;
    private InputView inputView = InputView.getInstance();

    public ApplicationContext(ShortestDistance shortestDistance,
                                MinimumTime minimumTime) {
        this.shortestDistance = shortestDistance;
        this.minimumTime = minimumTime;
    }

    public void run() {
        ManagementType managementType = ManagementType.STATION;
        while (managementType.isRunning()) {
            try {
                String state = inputView.inputMainMenu();
                managementType = ManagementType.findManagementNumber(state);
                executeFunction(managementType);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void executeFunction(ManagementType managementType) {
        if (managementType == ManagementType.QUIT) {
            return;
        }
        selectRouteCriteria(managementType);
    }

    private void selectRouteCriteria(ManagementType managementType) {
        try {
            String state = inputView.inputRouteCriteria();
            FunctionType functionType = managementType.findFunctionNumber(state);
            selectRouteToProcess(functionType);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            selectRouteCriteria(managementType);
        }
    }

    private void selectRouteToProcess(FunctionType functionType) {
        if (functionType == FunctionType.BACK) {
            return;
        }
        if (functionType == FunctionType.SHORTEST_DISTANCE) {
            shortestDistance.calculateShortestDistance();
        }
        if (functionType == FunctionType.MINIMUM_TIME) {

        }
    }
}
